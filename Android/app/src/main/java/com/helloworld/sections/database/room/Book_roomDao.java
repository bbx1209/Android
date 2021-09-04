package com.helloworld.sections.database.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Book_roomDao {

    @Insert
    void insertBooks(Book_room... book_rooms);
    @Update
    void updateBooks(Book_room ... book_rooms);
    @Delete
    void deleteBooks(Book_room ... book_rooms);
    @Query("delete from Book_room")
    void deleteAllBooks();
    @Query("select * from Book_room order by id DESC")
    List<Book_room>getAllBook();

}
