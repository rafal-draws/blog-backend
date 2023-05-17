package eu.conclusions.blog.services;

import eu.conclusions.blog.dao.BlogPostRepository;
import eu.conclusions.blog.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService{

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public List<BlogPost> findAll(){
        return blogPostRepository.findAll();
    }

    @Override
    public List<BlogPost> findAllEn() {
        return blogPostRepository.findByLanguage("en");
    }

    @Override
    public List<BlogPost> findAllPl() {
        return blogPostRepository.findByLanguage("pl");
    }

    public BlogPost findById(Long id){
        Optional<BlogPost> result = blogPostRepository.findById(id);

        BlogPost blogPost = null;

        if (result.isPresent()) {
            blogPost = result.get();
        } else {
            throw new RuntimeException("didn't find the blog post for id " + id);
        }
        return blogPost;
    }

    @Override
    public void save(BlogPost blogPost){
        blogPostRepository.save(blogPost);
    }

    @Override
    public void deleteById(Long theId) {
        blogPostRepository.deleteById(theId);
    }
}
