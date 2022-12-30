package com.sping.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @Column(name = "POST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "POST_TITLE", length = 45)
    private String title;

    @Column(name = "POST_TEXT", columnDefinition = "LONGTEXT")
    private String text;

    @Column(name = "POST_CREATE_DT")
    private Date created;

    @Column(name = "POST_LIKE_CNT")
    private Long likeCnt;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "post")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Command> commands = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Tag> tags = new ArrayList<>();

    public void setBlog(Blog blog) {
        this.blog = blog;

        if (!blog.getPosts().contains(this)) {
            blog.getPosts().add(this);
        }
    }
}
