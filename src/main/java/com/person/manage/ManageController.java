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
@RequestMapping("/manage/")
public class ManageController {

    protected static final Logger logger = LoggerFactory.getLogger(ManageController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model , HttpSession httpSession) {
        return "manage/home";
    }

}
