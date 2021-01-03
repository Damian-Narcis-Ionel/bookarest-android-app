package com.example.bookarest;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithBooks {
    @Embedded public User user;
    @Relation(
            parentColumn = "userId",
            entityColumn = "bookId",
            associateBy = @Junction(UserBookCrossRef.class)
    )

    public List<Book> books;

}
