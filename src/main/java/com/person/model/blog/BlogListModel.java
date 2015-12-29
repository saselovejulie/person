package com.person.model.blog;


import com.person.model.base.BlogModel;

import java.util.List;

public class BlogListModel {
    private int pageSize;
    private int pageNumber;
    private long total;
    private List <BlogModel> blogList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getBlogList() {
        return blogList;
    }

    public void setBlogList(List <BlogModel> blogList) {
        this.blogList = blogList;
    }

    @Override
    public String toString() {
        return "BlogList{" +
                "pageSize:" + pageSize +
                ", pageNumber:" + pageNumber +
                ", total:" + total +
                ", blogList:" + blogList +
                '}';
    }
}
