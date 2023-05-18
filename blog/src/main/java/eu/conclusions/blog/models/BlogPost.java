package eu.conclusions.blog.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;
    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "date", columnDefinition = "timestamp")
    private Instant date;

    @Column(name = "language")
    private String language;

    public BlogPost(String title, String content, String language){
        this.title = title;
        this.content = content;
        this.slug = title.toLowerCase().replace(" ", "-");
        this.date = Instant.now();
        this.language = language;
    }

}
