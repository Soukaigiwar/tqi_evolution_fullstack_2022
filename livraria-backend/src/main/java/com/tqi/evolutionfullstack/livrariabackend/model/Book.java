package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tab_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    @Column(length = 50)
    private String title;
    @Column(length = 50)
    private String  author;
    @Column(length = 30)
    private String  publisher;
    @Column(length = 255)
    private String  img;
    @Column
    private Integer publishedYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
}
