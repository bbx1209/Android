package com.helloworld.sections.database.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;
import com.helloworld.sections.database.room.Book_room;
import com.helloworld.sections.database.room.RoomHelper;

public class RoomActivity extends AppCompatActivity {

    private RoomHelper roomHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomHelper = new RoomHelper(this);

    }

    //插入
    public void inserAction(View view) {
        Book_room book1 = new Book_room("llala", "sdfgs", 300.1, 100);
        Book_room book2 = new Book_room("ghdgh", "4563", 30.1, 160);
        roomHelper.inserBook(book1, book2);
    }

    //更新
    public void updateAction(View view) {
        Book_room book1 = new Book_room("llala", "sdfgs", 600.1, 100);
        book1.setId(2);
        roomHelper.updateBook(book1);
    }

    //条件删除
    public void deleteAction(View view) {
        Book_room book1 = new Book_room();
        book1.setId(1);
        roomHelper.updateBook(book1);
    }

    //全部删除
    public void deleteAllAction(View view) {
        roomHelper.deleteAllBook();
    }

    //查询
    public void queryAction(View view) {
        roomHelper.queryAllBook();
    }
}