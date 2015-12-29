package com.person.api.manage;

import com.person.model.base.BlogModel;
import com.person.model.base.ResponseMessageModel;
import com.person.model.blog.BlogListModel;
import com.person.service.mongo.blog.BlogService;
import com.person.util.FileManage;
import org.markdown4j.Markdown4jProcessor;
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
@RequestMapping("/api/manage/blog")
public class ApiBlogManageController {

    protected static final Logger logger = LoggerFactory.getLogger(ApiBlogManageController.class);

    @Autowired
    BlogService blogService;

    @Autowired
    FileManage fileManage;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessageModel create(@RequestParam("title") String title, @RequestParam("types") String types, @RequestParam("tags") String tags, @RequestParam("description") String description, @RequestParam(value = "content" , required = false) String content, HttpSession httpSession) throws Exception {

        ResponseMessageModel result = new ResponseMessageModel();

        fileManage.createMdFile();
        fileManage.writeMdFile(content);
        fileManage.createHtmlFile();

        String markDown = new Markdown4jProcessor().process(fileManage.readFile(fileManage.getMdPath() + fileManage.getMdFileName()));

        StringBuffer html = new StringBuffer();
        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"en\">");
        html.append("<head>");
        html.append("<title>" + title + "</title>");
        html.append("<meta charset=\"utf-8\">");
        html.append("<link rel=\"stylesheet\" href=\"http://cdn.conglin-site.com/lib/github-markdown-css-gh-pages/github-markdown.css\">");
        html.append("<style>");
        html.append(".markdown-body {box-sizing: border-box; min-width: 200px;max-width: 980px; margin: 0 auto; padding: 45px;}");
        html.append("</style>");
        html.append("</head>");
        html.append("<body class=\"markdown-body\">");
        html.append(markDown);
        html.append("</body>");
        html.append("</html>");

        fileManage.writeHtmlFile(html.toString());



        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BlogModel blog = new BlogModel();

        blog.setTitle(title);
        blog.setDescription(description);
        blog.setTags(tags.split(","));
        blog.setTypes(types.split(","));
        blog.setDate(dateFormat.format(new Date()));
        blog.setUpdateDate(dateFormat.format(new Date()));
        blog.setDocumentSaveLink(fileManage.getMdPath() + fileManage.getMdFileName());
        blog.setDocumentViewLink(fileManage.getViewHtmlPath() + fileManage.getHtmlFileName());
        blogService.saveBlog(blog);

        result.setStatus("200");
        result.setMessage("Success");


        logger.info(html.toString());

        return result;
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody
    BlogListModel test(){
        return  blogService.getBlogList(9,1);
    }
}
