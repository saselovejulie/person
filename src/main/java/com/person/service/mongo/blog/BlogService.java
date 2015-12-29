package com.person.service.mongo.blog;

import com.person.model.blog.BlogListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.person.model.base.BlogModel;

import java.util.List;

@Service
public class BlogService {

    private static String USER_COLLECTION = "blog";

    @Autowired
    MongoTemplate mongoTemplate;

    protected static final Logger logger = LoggerFactory.getLogger(BlogService.class);

    public void saveBlog(BlogModel blog){
        mongoTemplate.save(blog, USER_COLLECTION);
    }

    public BlogListModel getBlogList(int pageSize, int pageNumber){

        BlogListModel result = new BlogListModel();
        result.setPageNumber(pageNumber);
        result.setPageSize(pageSize);

        Query query = new Query();

        result.setTotal(this.mongoTemplate.count(query, BlogModel.class));
        logger.info("blog total:" + result.getTotal());

        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"date")));
        query.skip((pageNumber - 1) * pageSize );
        query.limit(pageSize);

        result.setBlogList(mongoTemplate.find(query,BlogModel.class));

        return result;


    }
}
