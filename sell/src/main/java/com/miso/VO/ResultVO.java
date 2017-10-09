package com.miso.VO;

import lombok.Data;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data; //返回的具体内容

}
