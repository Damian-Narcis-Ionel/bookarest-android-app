package com.example.bookarest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface AuthorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAuthor(Author author);

    @Delete
    public void deleteAuthor(Author author);

    @Query("SELECT * FROM Authors")
    public List<Author> getAllAuthors();

    @Transaction
    @Query("SELECT * FROM Authors")
    public List<AuthorWithBooks> getAuthorsWithBooks();

    @Query("DELETE FROM AUTHORS")
    public void deleteAuthors();

}
