package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
/*@WebFilter("/*")*/
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        log.info("请求路径:{}", url);

        if(url.contains("/login")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌:{},token:{}", url, token);

        if(!StringUtils.hasLength(token)){
            log.info("Token不存在");
            Result responseResult = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        try{
            JwtUtils.parseJWT(token);
        }catch (Exception e){
            log.info("令牌解析失败!");
            Result responseResult = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        log.info("验证成功，准备相应请求...");
        filterChain.doFilter(request, response);
    }
}
