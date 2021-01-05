package com.example.bookarest;

import androidx.room.Entity;

import java.io.Serializable;

@Entity(tableName ="UserBookCrossRef" , primaryKeys = {"userId","bookId"})
public class UserBookCrossRef implements Serializable {
    public int userId;
    public int bookId;
    public int category;

    public UserBookCrossRef(int userId, int bookId, int category) {
        this.userId = userId;
        this.bookId = bookId;
        this.category = category;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "UserBookCrossRef{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", category=" + category +
                '}';
    }
}
