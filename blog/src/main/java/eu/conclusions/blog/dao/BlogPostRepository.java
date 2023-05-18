package eu.conclusions.blog.dao;

import eu.conclusions.blog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByLanguage(String language);

    Optional<BlogPost> findBySlug(String slug);
}
