package com.sping.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Command")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Command {
    @Id
    @Column(name = "COMMAND_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COMMAND_CONTENT")
    private String content;

    @Column(name = "COMMAND_CREATE_DT")
    private Date create_dt;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
