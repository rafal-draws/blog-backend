package eu.conclusions.backend.Beans;

import eu.conclusions.backend.Entities.BlogPost;
import eu.conclusions.backend.Repositories.BlogPostRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BlogPostRepository repository){

        return args -> {
            log.info("Preloading " + repository.save(
                    new BlogPost("pierwszy post",
                            "pierwszy-post",
                            "zawartosc pierwszego posta, lorem ipsum scrotum profanum")

            ));
            log.info("Preloading " + repository.save(
                    new BlogPost("drugi post",
                            "drugi-post",
                            "zawartosc drugiego posta, lorem ipsum scrotum profanum")

            ));
        };

    }
}
