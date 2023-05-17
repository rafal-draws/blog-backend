package eu.conclusions.blog.beans;

import eu.conclusions.blog.dao.BlogPostRepository;
import eu.conclusions.blog.models.BlogPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInit {

    public static final Logger log = LoggerFactory.getLogger(DataInit.class);

//    @Bean
//    CommandLineRunner initDatabase(BlogPostRepository blogPostRepository){
//        return args -> {
//            log.info("Preloading " + blogPostRepository.save(
//                    new BlogPost("pierwszy post", "zawartosc pierwszego posta", "en")));
//            log.info("Preloading "  + blogPostRepository.save(
//                    new BlogPost("drugi post", "zawartosc drugiego posta", "pl")
//            ));
//        };
//    }

}
