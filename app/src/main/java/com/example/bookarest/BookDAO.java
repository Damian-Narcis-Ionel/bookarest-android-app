package com.example.bookarest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBook(Book book);

    @Delete
    public void deleteBook(Book book);

    @Query("SELECT * FROM books")
    List<Book> getAllBooks();


}
