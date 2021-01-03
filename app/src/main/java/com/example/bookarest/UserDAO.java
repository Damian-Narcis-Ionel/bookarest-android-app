package com.example.bookarest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User user);

    @Delete
    public void deleteUser(User user);

    @Query("SELECT * FROM USERS")
    List<User> getAllUsers();

    @Transaction
    @Query("SELECT * FROM Users")
    List<UserWithBooks> getUserWithBooks();
}
