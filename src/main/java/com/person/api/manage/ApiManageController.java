package com.person.api.manage;

import com.person.model.base.BlogModel;
import com.person.service.mongo.blog.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@SessionAttributes
@RequestMapping("/api/manage")
public class ApiManageController {
    protected static final Logger logger = LoggerFactory.getLogger(ApiManageController.class);

    @Autowired
    BlogService blogService;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    BlogModel insert(@RequestParam("title") String title, @RequestParam("types") String types, @RequestParam("tags") String tags, HttpSession httpSession){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BlogModel blog = new BlogModel();

        blog.setTitle(title);
        blog.setTags(tags.split(","));
        blog.setTypes(types.split(","));
        blog.setDate(dateFormat.format(new Date()));
        blog.setUpdateDate(dateFormat.format(new Date()));
        blog.setDocumentSaveLink("save link");
        blog.setDocumentViewLink("view link");

        blogService.saveBlog(blog);

        return blog;
    }
}
