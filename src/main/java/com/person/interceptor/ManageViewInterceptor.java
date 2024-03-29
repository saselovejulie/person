package com.person.interceptor;

import com.person.model.properties.BlogSettingProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台管理视图拦截器
 */
public class ManageViewInterceptor implements HandlerInterceptor {

    @Autowired
    BlogSettingProperties blogSettingProperties;

    protected static final Logger logger = LoggerFactory.getLogger(ManageViewInterceptor.class);

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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        logger.info("-------------");

        request.setAttribute("siteUrl",blogSettingProperties.getSiteUrl());
        request.setAttribute("cdnLibPath", blogSettingProperties.getCdnLibPath());
        request.setAttribute("manageStatic",blogSettingProperties.getManageStatic());


        return true;
    }
}
