package eu.conclusions.blog.dao;

import eu.conclusions.blog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
