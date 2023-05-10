package eu.conclusions.backend.Repositories;

import eu.conclusions.backend.Entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
