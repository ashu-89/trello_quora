package com.upgrad.quora.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "question")
@NamedQueries(
        {
            @NamedQuery(name = "questionByUuid", query = "select q from QuestionEntity q where q.uuid = :uuid"),
            @NamedQuery(name = "questionsByUser", query = "select q from QuestionEntity q where q.user = :user"),
        }
)

public class QuestionEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uuid")
    @Size(max = 200)
    private String uuid;

    @Column(name = "content")
    @Size(max = 500)
    private String content;

    @Column(name = "date")
    @NotNull
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getUuid() {return uuid;}

    public void setUuid(String uuid) {this.uuid = uuid;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public UserEntity getUser() {return user;}

    public void setUser(UserEntity user) {this.user = user;}

}
