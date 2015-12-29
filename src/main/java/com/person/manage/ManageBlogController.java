package com.person.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes
@RequestMapping("/manage/blog/")
public class ManageBlogController {

    protected static final Logger logger = LoggerFactory.getLogger(ManageBlogController.class);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String home(ModelMap model , HttpSession httpSession) {
        return "manage/blog/blogEdit";
    }
}
