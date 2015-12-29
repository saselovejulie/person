package com.person.blog;


import com.person.model.properties.BlogSettingProperties;
import com.person.service.mongo.blog.BlogService;
import com.person.util.FileManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class HomeController {

    protected static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    BlogService blogService;

    @Autowired
    FileManage fileManage;

    @Autowired
    BlogSettingProperties blogSettingProperties;


    @RequestMapping(value ={"/","/list/{page}"}, method = RequestMethod.GET)
    public String home(HttpServletRequest request, @PathVariable Optional <Integer> page)  {


        //后期构建缓存,取最新10条记录
        request.setAttribute("lastBlog", blogService.getBlogList(10,1));

        if (page.isPresent()) {
            request.setAttribute("blog", blogService.getBlogList(9,page.get()));
        } else {
            request.setAttribute("blog", blogService.getBlogList(9,1));
        }

        return "blog/home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap model){

        return "blog/home";
    }


}
