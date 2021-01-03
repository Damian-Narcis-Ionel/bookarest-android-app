package com.example.bookarest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Books")
public class Book {
    @PrimaryKey()
    private int bookId;

    @ColumnInfo(name="Title")
    private String title;

    @ColumnInfo(name = "AuthorId")
    private int authorOfBookId;

    @ColumnInfo(name = "NumberOfPages")
    private int numberOfPages;

    public Book(int bookId, String title, int authorOfBookId, int numberOfPages) {
        this.bookId = bookId;
        this.title = title;
        this.authorOfBookId = authorOfBookId;
        this.numberOfPages = numberOfPages;
    }

    public Book(){}

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorOfBookId() {
        return authorOfBookId;
    }

    public void setAuthorOfBookId(int authorId) {
        this.authorOfBookId = authorId;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorOfBookId=" + authorOfBookId +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
