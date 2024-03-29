package org.example.technologie_sieciowe_1.infrastructure.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer loanid;

    @ManyToOne // git
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity user;

    @Basic
    @Column(name = "loanDate")
    private Date loanDate;
    @Basic
    @Column(name = "loanEndDate")
    private Date loanEndDate;
    @Basic
    @Column(name = "returnDate")
    private Date returnDate;

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(Date loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
