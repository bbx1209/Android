package com.helloworld.sections.database.room;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Book_room")
public class Book_room {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private  String name;
    private String author;
    private  double price;
    private int pages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book_room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }
}
