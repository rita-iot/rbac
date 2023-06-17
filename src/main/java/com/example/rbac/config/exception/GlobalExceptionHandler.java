package com.example.rbac.config.exception;


import com.example.rbac.config.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lxh
 * @description: web 异常处理
 */
@Slf4j
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception e) {
        //log.error("捕获全局统一异常：" + e.getMessage());
        //log.error(e.toString());
        //log.error(e.getStackTrace().toString());
        e.printStackTrace();
        return new R(500, e.getMessage());
    }


    /**
     * 捕获空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public R exceptionHandler3(NullPointerException e) {
        log.error("捕获NullPointerException异常：" + e.getMessage());
        //System.out.println(e.getMessage());
        //System.out.println(Arrays.toString(e.getStackTrace()));
        //log.error(String.valueOf(e.getStackTrace()));
        e.printStackTrace();
        return new R(5002, "对象空制针异常!");
    }
    //@ExceptionHandler(value = BadCredentialsException.class)
    //public Result<?> BadCredentialsException(BadCredentialsException e) {
    //    log.error("捕获NullPointerException异常：" + e.getMessage());
    //    //System.out.println(e.getMessage());
    //    //System.out.println(Arrays.toString(e.getStackTrace()));
    //    //log.error(String.valueOf(e.getStackTrace()));
    //    e.printStackTrace();
    //    return Result.fail(401, "用户名或密码错误");
    //}
    ///**
    // * 捕获token过期异常
    // * @param e
    // * @return
    // */
    //@ExceptionHandler(value = ExpiredJwtException.class)
    //public Result exceptionHandler3(ExpiredJwtException e) {
    //    log.error("捕获ExpiredJwtException异常：" + e.getMessage());
    //    //System.out.println(e.getMessage());
    //    //System.out.println(Arrays.toString(e.getStackTrace()));
    //    //log.error(String.valueOf(e.getStackTrace()));
    //    e.printStackTrace();
    //    return Result.fail(5002, "token已过期，请重新登录", e.getStackTrace()[0]);
    //}
}
