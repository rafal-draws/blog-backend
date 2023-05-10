package eu.conclusions.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BlogPost {

    private @Id @GeneratedValue Long id;
    private String title;
    private String slug;
    private String content;

    public BlogPost() {}

    public BlogPost(String title, String slug, String content) {
        this.title = title;
        this.slug = slug;
        this.content = content;
    }


}
