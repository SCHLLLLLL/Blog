package com.day1.web;

import com.day1.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchiveController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archive")
    public String archive(Model model){
        model.addAttribute("archive",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }
}
