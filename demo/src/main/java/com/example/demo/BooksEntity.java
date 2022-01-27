package com.example.demo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books", schema = "public", catalog = "library")
public class BooksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "isbn", nullable = false, length = 13)
    private String isbn;
    @Basic
    @Column(name = "title", nullable = false, length = 90)
    private String title;
    @Basic
    @Column(name = "copies", nullable = true)
    private Integer copies;
    @Basic
    @Column(name = "cover", nullable = true, length = 255)
    private String cover;
    @Basic
    @Column(name = "outline", nullable = false, length = 255)
    private String outline;
    @Basic
    @Column(name = "publisher", nullable = true, length = 60)
    private String publisher;
    @OneToMany(mappedBy = "book")
    private List<LendingEntity> borrowedBy;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksEntity that = (BooksEntity) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(title, that.title) && Objects.equals(copies, that.copies) && Objects.equals(cover, that.cover) && Objects.equals(outline, that.outline) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, copies, cover, outline, publisher);
    }

    public List<LendingEntity> getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(List<LendingEntity> borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
