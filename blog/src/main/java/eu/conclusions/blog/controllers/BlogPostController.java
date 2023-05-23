package eu.conclusions.blog.controllers;

import eu.conclusions.blog.models.BlogPost;
import eu.conclusions.blog.services.BlogPostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService theBlogPostService){
        blogPostService = theBlogPostService;
    }



    @GetMapping("/")
    public String index() {
        return "redirect:/en";
    }

    @GetMapping("/pl")
    public String indexPl() {
        return "redirect:/pl/posts";
    }

    @GetMapping("/en")
    public String indexEn() {
        return "redirect:/en/posts";
    }

    @GetMapping("/en/posts")
    @Transactional
    public String listPostsEn(Model theModel){

        List<BlogPost> blogPosts = blogPostService.findAllEn();

        Collections.reverse(blogPosts);

        theModel.addAttribute("blogPosts", blogPosts);
        return "en_blogPosts.html";
    }

    @GetMapping("/pl/posts")
    @Transactional
    public String listPostsPl(Model theModel){

        List<BlogPost> blogPosts = blogPostService.findAllPl();

        Collections.reverse(blogPosts);

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

    @GetMapping("/pl/contact")
    public String showContactPl(Model theModel){

        return "pl_contact.html";
    }

    @GetMapping("/en/contact")
    public String showContactEn(Model theModel){

        return "en_contact.html";
    }




}
