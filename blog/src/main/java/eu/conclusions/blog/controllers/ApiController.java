package eu.conclusions.blog.controllers;

import eu.conclusions.blog.models.BlogPost;
import eu.conclusions.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;

@Controller
public class ApiController {

    private BlogPostService blogPostService;
    private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    public ApiController(BlogPostService theBlogPostService){
        blogPostService = theBlogPostService;
    }

    @PostMapping("/api/add_post")
    @ResponseBody
    public BlogPost addPost(@RequestBody BlogPost blogPost){
        blogPost.setId(0L);
        blogPost.setSlug(blogPost.getTitle().toLowerCase().replace(" ", "-"));
        blogPost.setDate(Instant.now());
        BlogPost dbBlogPost = blogPostService.save(blogPost);
        return dbBlogPost;
    }

}
