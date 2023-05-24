package eu.conclusions.blog.controllers;

import eu.conclusions.blog.models.BlogPost;
import eu.conclusions.blog.services.BlogPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ApiController {

    private BlogPostService blogPostService;

    public ApiController(BlogPostService theBlogPostService){
        blogPostService = theBlogPostService;
    }

    @PostMapping("/api/posts")
    @ResponseBody
    public BlogPost addPost(@RequestBody BlogPost blogPost) {
        BlogPost dbBlogPost = blogPostService.save(blogPost);
        return dbBlogPost;
    }

    @GetMapping("/api/posts/{id}")
    @ResponseBody
    public BlogPost getPost(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.findById(id);
        return blogPost;
    }

    @GetMapping("/api/posts/en")
    @ResponseBody
    public List<BlogPost> getEnPosts() {
        List<BlogPost> blogPosts = blogPostService.findAllEn();
        return blogPosts;
    }

    @GetMapping("/api/posts/pl")
    @ResponseBody
    public List<BlogPost> getPlPosts() {
        List<BlogPost> blogPosts = blogPostService.findAllPl();
        return blogPosts;
    }

    @PutMapping("/api/posts/{id}")
    @ResponseBody
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost updatedPostData) {
        BlogPost existingPost = blogPostService.findById(id);
        if (existingPost != null) {
            existingPost.setTitle(updatedPostData.getTitle());
            existingPost.setContent(updatedPostData.getContent());
            BlogPost updatedPost = blogPostService.save(existingPost);
            return updatedPost;
        }
        return null;
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseBody
    public String deletePost(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.findById(id);
        blogPostService.deleteById(id);
        return "blog post -> " + blogPost.getTitle() + " has been deleted";
    }


}
