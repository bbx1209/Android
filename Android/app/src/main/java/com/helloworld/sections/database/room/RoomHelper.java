package com.helloworld.sections.database.room;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class RoomHelper {

    private Book_roomDao book_roomDao;

    public RoomHelper(Context context) {
        Book_roomDatabase database = Book_roomDatabase.getInstance(context);

        book_roomDao = database.getBook_roomDao();
    }


    public void inserBook(Book_room... book_rooms) {
        new insertAsyncTask(book_roomDao).execute(book_rooms);
    }

    public void updateBook(Book_room... book_rooms) {
        new updatetAsyncTask(book_roomDao).execute(book_rooms);
    }

    public void deleteBook(Book_room... book_rooms) {
        new deleteAsyncTask(book_roomDao).execute(book_rooms);

    }

    public void deleteAllBook() {
        new deleteAllAsyncTask(book_roomDao).execute();
    }

    public List<Book_room> queryAllBook() {
        new queryAllAsyncTask(book_roomDao).execute();
        return null;
    }


    private static class insertAsyncTask extends AsyncTask<Book_room, Void, Void> {
        private Book_roomDao dao;

        public insertAsyncTask(Book_roomDao book_roomDao) {
            dao = book_roomDao;
        }

        @Override
        protected Void doInBackground(Book_room... book_rooms) {
            dao.insertBooks(book_rooms);
            return null;
        }
    }

    private static class updatetAsyncTask extends AsyncTask<Book_room, Void, Void> {
        private Book_roomDao dao;

        public updatetAsyncTask(Book_roomDao book_roomDao) {
            dao = book_roomDao;
        }

        @Override
        protected Void doInBackground(Book_room... book_rooms) {
            dao.updateBooks(book_rooms);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Book_room, Void, Void> {
        private Book_roomDao dao;

        public deleteAsyncTask(Book_roomDao book_roomDao) {
            dao = book_roomDao;
        }

        @Override
        protected Void doInBackground(Book_room... book_rooms) {
            dao.deleteBooks(book_rooms);
            return null;
        }
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private Book_roomDao dao;

        public deleteAllAsyncTask(Book_roomDao book_roomDao) {
            dao = book_roomDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllBooks();
            return null;
        }
    }

    private static class queryAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private Book_roomDao dao;

        public queryAllAsyncTask(Book_roomDao book_roomDao) {
            dao = book_roomDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Book_room> allBook = dao.getAllBook();
            for (Book_room room : allBook) {
                Log.d("Room helper", "doInBackground: " + room.toString());
            }
            return null;
        }
    }


}
