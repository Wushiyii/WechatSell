package com.miso.service.impl;

import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.miso.dto.OrderDTO;
import com.miso.service.PayService;
import org.springframework.stereotype.Service;

/**
 * Created by Wushiyi on 2017-10-20.
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public void create(OrderDTO orderDTO) {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
    }
}
