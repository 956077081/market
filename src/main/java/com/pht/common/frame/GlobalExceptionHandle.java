package com.pht.common.frame;

import com.pht.common.BizException;
import com.pht.common.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 异常处理
     * @param biz
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {BizException.class})
    public CommonResult handleBizException(BizException biz){
        return CommonResult.failed(biz.getErrMesg());
    }

}
