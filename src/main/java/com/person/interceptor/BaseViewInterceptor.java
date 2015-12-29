package com.person.interceptor;

import com.person.model.properties.BlogSettingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基本视图文件拦截器
 */
public class BaseViewInterceptor implements HandlerInterceptor {

    @Autowired
    BlogSettingProperties blogSettingProperties;


    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {

        request.setAttribute("siteUrl",blogSettingProperties.getSiteUrl());
        request.setAttribute("cdnPath",blogSettingProperties.getCdnPath());
        request.setAttribute("cdnLibPath", blogSettingProperties.getCdnLibPath());


        return true;
    }
}
