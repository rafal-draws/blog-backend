package eu.conclusions.blog.controllers;

import eu.conclusions.blog.models.BlogPost;
import eu.conclusions.blog.services.BlogPostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@Controller
public class BlogPostController {

    private BlogPostService blogPostService;
    private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    public BlogPostController(BlogPostService theBlogPostService){
        blogPostService = theBlogPostService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/en/posts";
    }

    @GetMapping("/{lang}")
    public String redirectToLanguage(@PathVariable String lang) {
        if (lang.equals("en"))
        return "redirect:/en/posts";
        else return "redirect:/pl/posts";
    }

    @GetMapping("/en/posts")
    @Transactional
    public String listPostsEn(Model theModel){

        List<BlogPost> blogPosts = blogPostService.findAllEn();

        theModel.addAttribute("blogPosts", blogPosts);
        return "en_blogPosts.html";
    }

    @GetMapping("/pl/posts")
    @Transactional
    public String listPostsPl(Model theModel){

        List<BlogPost> blogPosts = blogPostService.findAllPl();

        theModel.addAttribute("blogPosts", blogPosts);
        return "pl_blogPosts.html";
    }

    @GetMapping("/en/posts/{slug}")
    @Transactional
    public String showPostEn(Model theModel, @PathVariable String slug){

        BlogPost blogPost = blogPostService.findBySlug(slug);

        theModel.addAttribute("blogPost", blogPost);
        return "en_post.html";
    }


    @GetMapping("/pl/posts/{slug}")
    @Transactional
    public String showPostPl(Model theModel, @PathVariable String slug){

        BlogPost blogPost = blogPostService.findBySlug(slug);

        theModel.addAttribute("blogPost", blogPost);
        return "pl_post.html";
    }




}
