package eu.conclusions.blog.services;

import eu.conclusions.blog.models.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogPostService {

    List<BlogPost> findAll();

    List<BlogPost> findAllEn();

    List<BlogPost> findAllPl();

    BlogPost findById(Long id);

    void save(BlogPost blogPost);

    void deleteById(Long theId);


}
