package eu.conclusions.blog.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInit {

    public static final Logger log = LoggerFactory.getLogger(DataInit.class);

//    @Bean
//    CommandLineRunner initDatabase(BlogPostRepository blogPostRepository){
//        return args -> {
//            log.info("Preloading " + blogPostRepository.save(
//                    new BlogPost("pierwszy post", "zawartosc pierwszego posta")));
//            log.info("Preloading "  + blogPostRepository.save(
//                    new BlogPost("drugi post", "zawartosc drugiego posta")
//            ));
//        };
//    }

}
