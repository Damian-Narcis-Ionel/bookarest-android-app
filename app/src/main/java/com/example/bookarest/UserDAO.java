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

    @Query("SELECT * FROM USERS WHERE Email=:email")
    User getUserByEmail(String email);

    @Query("SELECT COUNT(*) FROM USERS WHERE Email=:email and password =:password")
    int getMatchingUser(String email, String password);

    @Query("SELECT COUNT(*) FROM USERS WHERE Email=:email")
    int checkExistingEmail(String email);

    @Query("SELECT MAX(userId) FROM users")
    int getMaxUserId();
}
