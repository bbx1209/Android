package com.helloworld.sections.database.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.helloworld.sections.database.room.Book_roomDao;
import com.helloworld.sections.database.room.Book_room;


@Database(entities = {Book_room.class}, version = 1, exportSchema = false)
public abstract class Book_roomDatabase extends RoomDatabase {

    public abstract Book_roomDao getBook_roomDao();

    private  static  Book_roomDatabase instance;

    public  synchronized static  Book_roomDatabase getInstance(Context context){
      if (instance == null) {
          instance = Room.databaseBuilder
                  (context.getApplicationContext(), Book_roomDatabase.class, "Book_room")
                  .build();
      }
      return instance;
    }


}
