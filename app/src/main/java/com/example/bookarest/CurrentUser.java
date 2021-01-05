package com.example.bookarest;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class CurrentUser implements Serializable {
    private User user;
    private List<Book> wantToRead;
    private List<Book> currentlyReading;
    private List<Book> read;


    public CurrentUser(User user, List<Book> wantToRead, List<Book> currentlyReading, List<Book> read) {
        this.user = user;
        this.wantToRead = wantToRead;
        this.currentlyReading = currentlyReading;
        this.read = read;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getWantToRead() {
        return wantToRead;
    }

    public void setWantToRead(List<Book> wantToRead) {
        this.wantToRead = wantToRead;
    }

    public List<Book> getCurrentlyReading() {
        return currentlyReading;
    }

    public void setCurrentlyReading(List<Book> currentlyReading) {
        this.currentlyReading = currentlyReading;
    }

    public List<Book> getRead() {
        return read;
    }

    public void setRead(List<Book> read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                ", wantToRead=" + wantToRead +
                ", currentlyReading=" + currentlyReading +
                ", read=" + read +
                '}';
    }
}
