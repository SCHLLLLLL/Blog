package com.day1.service;

import com.day1.po.Blog;
import com.day1.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface    BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Pageable pageable,Long tagId);

    Page<Blog> listBlog(String query, Pageable pageable);

    List<Blog> listBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    Long countBlog();
}
