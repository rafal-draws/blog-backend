package eu.conclusions.blog.controllers;

import eu.conclusions.blog.models.BlogPost;
import eu.conclusions.blog.services.BlogPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogPostController {

    private BlogPostService blogPostService;

    public BlogPostController(BlogPostService theBlogPostService){
        blogPostService = theBlogPostService;
    }


    @GetMapping("/")
    public String redirectToHello() {
        return "redirect:/en";
    }

    @GetMapping("/en")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }

    @GetMapping("/en/posts")
    public String listPosts(Model theModel){

        List<BlogPost> blogPosts = blogPostService.findAll();
        theModel.addAttribute("blogPosts", blogPosts);
        return "en_blogPosts.html";
    }




}
