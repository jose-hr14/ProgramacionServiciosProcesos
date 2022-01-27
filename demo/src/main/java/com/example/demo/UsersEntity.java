package com.example.demo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "library")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "code", nullable = false, length = 8)
    private String code;
    @Basic
    @Column(name = "name", nullable = false, length = 25)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = 25)
    private String surname;
    @Basic
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;
    @OneToMany(mappedBy = "borrower")
    private List<LendingEntity> lentBooks;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, surname, birthdate);
    }

    public List<LendingEntity> getLentBooks() {
        return lentBooks;
    }

    public void setLentBooks(List<LendingEntity> lentBooks) {
        this.lentBooks = lentBooks;
    }
}
