package com.example.oppo.demo.Interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 岗位权限
 * @author zhaozheng
 * @create 2019/2/11
 **/
public class JobInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
        System.out.println("request请求地址path uri{}"+request.getServletPath()+request.getRequestURI());
        return true;
    }

    /**
     * 根据token获取用户ID
     * @param userToken
     * @return
     */
    private Long getUserId(String userToken){
        Long userId = null;
        return userId;
    }

    /**
     * 校验用户访问权限
     * @param userId
     * @param requestURI
     * @return
     */
    private boolean checkAuth(Long userId,String requestURI){
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}
}


