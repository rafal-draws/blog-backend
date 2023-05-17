package eu.conclusions.blog.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String slug;
    @Lob
    @Column
    private String content;

    @Column
    private String date;

    @Column
    String language;

    public BlogPost(String title, String content, String language){
        this.title = title;
        this.content = content;
        this.slug = title.toLowerCase().replace(" ", "-");
        this.date = String.valueOf(LocalDateTime.now());
        this.language = language;
    }

}
