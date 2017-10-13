package com.miso.Controller;

import com.miso.VO.ResultVO;
import com.miso.converter.OrderForm2OrderDTOConverter;
import com.miso.dto.OrderDTO;
import com.miso.enums.ResultEnum;
import com.miso.exception.SellException;
import com.miso.form.OrderForm;
import com.miso.service.BuyerService;
import com.miso.service.impl.OrderServiceImpl;
import com.miso.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wushiyi on 2017-10-13.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String ,String>> createOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.ORDER_PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单] 购物车不能为空，orderDetail={}",orderDTO.getOrderDetailList());
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.createOrder(orderDTO);
        Map<String ,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value = "openid")String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10")Integer size){

        if(StringUtils.isEmpty(openid)){
            log.error("[查询订单列表]openid为空");
            throw new SellException(ResultEnum.OPENID_EMPTY);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findAll(openid, pageRequest);
        return ResultVOUtil.success(orderDTOPage.getContent());
        //return ResultVOUtil.success();

    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(String openid,String orderId){

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO<OrderDTO> cancel(String openid,String orderId){

        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }
}
