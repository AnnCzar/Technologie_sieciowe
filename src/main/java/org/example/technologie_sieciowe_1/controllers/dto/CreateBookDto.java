package org.example.technologie_sieciowe_1.controllers.dto;

public class CreateBookDto {

    private String isbn;
    private  String title;
    private String author;
    private String publisher;
    private Integer publishYear;
    private Integer numberCopy;

    public CreateBookDto(String isbn, String title, String author, String publisher, Integer publishYear, Integer numberCopy) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.numberCopy = numberCopy;
    }

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

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getNumberCopy() {
        return numberCopy;
    }

    public void setNumberCopy(Integer numberCopy) {
        this.numberCopy = numberCopy;
    }
}