package eu.conclusions.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Lob
    @Column
    private String content;

    @Column
    private Instant createdOn;

    @Column
    private Instant updatedOn;

    @Column
    private String username;


}
