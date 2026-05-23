package com.codesprint.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTitle;

    private String title;

    @Column(length = 1000)
    private String description;

    private String difficulty;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Question() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestionTitle() { return questionTitle; }
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
        this.title = questionTitle; // keep in sync
    }

    public String getTitle() { return title != null ? title : questionTitle; }
    public void setTitle(String title) { this.title = title; this.questionTitle = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }
}
