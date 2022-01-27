package com.example.demo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lending", schema = "public", catalog = "library")
public class LendingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "lendingdate", nullable = false)
    private Date lendingdate;
    @Basic
    @Column(name = "returningdate", nullable = true)
    private Date returningdate;
    @ManyToOne
    @JoinColumn(name = "borrower", referencedColumnName = "code", nullable = false)
    private UsersEntity borrower;
    @ManyToOne
    @JoinColumn(name = "book", referencedColumnName = "isbn", nullable = false)
    private BooksEntity book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLendingdate() {
        return lendingdate;
    }

    public void setLendingdate(Date lendingdate) {
        this.lendingdate = lendingdate;
    }

    public Date getReturningdate() {
        return returningdate;
    }

    public void setReturningdate(Date returningdate) {
        this.returningdate = returningdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LendingEntity that = (LendingEntity) o;
        return id == that.id && Objects.equals(lendingdate, that.lendingdate) && Objects.equals(returningdate, that.returningdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lendingdate, returningdate);
    }

    public UsersEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(UsersEntity borrower) {
        this.borrower = borrower;
    }

    public BooksEntity getBook() {
        return book;
    }

    public void setBook(BooksEntity book) {
        this.book = book;
    }
}
