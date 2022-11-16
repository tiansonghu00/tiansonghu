package com.tian.bookSystem;

import java.util.Objects;

public class Book {
    private Integer id;
    private String name;
    private String kind;//类别
    private String publishedTime;//借出日期
    private String author;
    private boolean status;//状态，通过T/F来表示是否借出
    private String returnTime;//还书日期

    public Book() {//显式定义无参构造器
    }
    public Book(Integer id, String name, String kind, String publishedTime, String author, boolean status) {
        this.id=id;
        this.name = name;
        this.kind = kind;
        this.publishedTime = publishedTime;
        this.author = author;
        this.status = status;
        this.returnTime="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", publishedTime='" + publishedTime + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", returnTime='" + returnTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(kind, book.kind) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, author);
    }
}
