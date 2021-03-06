package com.IskhakovaL.Olymp_task2.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {
    @Id
    @GeneratedValue private Long id;
    private String title;
    private String content;

    public Note() {}

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Note(String content){
        this.title = content.substring(0, 2);
        content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
