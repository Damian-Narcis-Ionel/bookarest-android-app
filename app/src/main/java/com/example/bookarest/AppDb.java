package com.example.bookarest;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Author.class,Book.class,User.class,UserBookCrossRef.class}, version = 1)
public abstract class AppDb extends RoomDatabase {

    public abstract  AuthorDAO authorDAO();
    public abstract  BookDAO bookDAO();
    public abstract  UserDAO userDAO();
    public abstract  UserBookCrossRefDAO UserBookCrossRefDAO();


}
