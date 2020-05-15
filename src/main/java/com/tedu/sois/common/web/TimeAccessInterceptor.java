package com.tedu.sois.common.web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.tedu.sois.common.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器对象,检查请求是否携带token
 * @author LYS
 */
public class TimeAccessInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(TimeAccessInterceptor.class);


    /**
     * token 校验
     *
     * @param httpServletRequest, httpServletResponse, o
     * @return boolean
     * @methodName preHandle
     * @author fusheng
     * @date 2019/1/3 0003
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle()");
        Map<String, String[]> mapIn = httpServletRequest.getParameterMap();
        JSON jsonObject = JSONUtil.parseObj(mapIn);
        StringBuffer stringBuffer = httpServletRequest.getRequestURL();

        LOG.info("httpServletRequest ,路径:" + stringBuffer + ",入参:" + JSONUtil.toJsonStr(jsonObject));

        //校验APP的登陆状态，如果token 没有过期
        LOG.info("come in preHandle");
        String oldToken = httpServletRequest.getHeader("token");
        LOG.info("token:" + oldToken);
        /*刷新token，有效期延长2小时*/
        if (StringUtils.isNotBlank(oldToken)) {
            Claims claims = null;
            try {
                claims = TokenUtil.parseJWT(oldToken);
            } catch (Exception e) {
                e.printStackTrace();
                String str = "{\"code\":801,\"msg\":\"登陆失效,请重新登录!!!\"}";
                dealErrorReturn(httpServletRequest, httpServletResponse, str);
                return false;
            }
            if (claims.getExpiration().getTime() > DateUtil.date().getTime()) {
                String userId = claims.getId();
                try {
                    String newToken = TokenUtil.createJWT(claims.getId(), claims.getSubject(), TokenUtil.EFFECTIVE_TIME);
                    LOG.info("new TOKEN:{}", newToken);
                    httpServletRequest.setAttribute("userId", userId);
                    httpServletResponse.setHeader("token", newToken);
                    LOG.info("flush token success ,{}", oldToken);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    String str = "{\"code\":801,\"msg\":\"登陆失效,请重新登录.\"}";
                    dealErrorReturn(httpServletRequest, httpServletResponse, str);
                    return false;
                }
            }
        }
        String str = "{\"code\":801,\"msg\":\"验证失效!请重新登录!\"}";
        dealErrorReturn(httpServletRequest, httpServletResponse, str);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

    /**
     * 返回错误信息给WEB
     *
     * @param httpServletRequest, httpServletResponse, obj
     * @return void
     * @methodName dealErrorReturn
     * @author fusheng
     * @date 2019/1/3 0003
     */
    public void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj) {
        String json = (String) obj;
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(json);

        } catch (IOException ex) {
            LOG.error("response error", ex);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
