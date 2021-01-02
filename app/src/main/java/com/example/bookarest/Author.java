package com.example.bookarest;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="Authors")
public class Author {
    @PrimaryKey(autoGenerate = true)
    private int authorId;
    @ColumnInfo(name = "Name")
    private String name;


    public Author(String name) {

        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int id) {
        this.authorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
