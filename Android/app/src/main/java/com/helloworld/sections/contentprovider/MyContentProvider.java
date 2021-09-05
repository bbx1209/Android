package com.helloworld.sections.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.helloworld.sections.database.MyDBhelper;

public class MyContentProvider extends ContentProvider {

    public static final int BOOK_DIR = 0;
    public static final int BOOK_ITEM = 1;
    public static final String AUTHORITY = "com.helloworld.provider";

    private static  final  String VND_PREFIX = "vnd.android.cursor";
    private static  final  String VND_SUFFIX = "/vnd." + AUTHORITY;
    private static UriMatcher uriMatcher;
    private MyDBhelper dBhelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, MyDBhelper.TABLENAME_BOOK, BOOK_DIR);
        uriMatcher.addURI(AUTHORITY, MyDBhelper.TABLENAME_BOOK + "/#", BOOK_DIR);
    }


    public MyContentProvider() {

    }

    @Override
    public boolean onCreate() {
        dBhelper = new MyDBhelper(getContext(), MyDBhelper.DATABASENAME, null, 1);
        return true;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        int row = 0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
              row = db.delete(MyDBhelper.TABLENAME_BOOK, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);

                row = db.delete(MyDBhelper.TABLENAME_BOOK, "id=?", new String[]{bookId});
                break;
            default:
        }

        return row;
    }

    @Override
    public String getType(Uri uri) {
        String type = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                type = VND_PREFIX +".dir"+ VND_SUFFIX + "book";
                break;
            case BOOK_ITEM:
                type = VND_PREFIX +".item"+ VND_SUFFIX + "book";
                break;
            default:
        }
        return type;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dBhelper.getWritableDatabase();
        Uri returnUri = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
            case BOOK_ITEM:
                long insert = db.insert(MyDBhelper.TABLENAME_BOOK, null, values);
                returnUri = Uri.parse("content://" + AUTHORITY + "/book/" + insert);
                break;
            default:
        }

        return returnUri;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = dBhelper.getWritableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                cursor = db.query(MyDBhelper.TABLENAME_BOOK, projection,selection, selectionArgs,null, null, sortOrder);
                break;
            case BOOK_ITEM:
              String itemId = uri.getPathSegments().get(1);
              cursor = db.query(MyDBhelper.TABLENAME_BOOK, projection, "id =?", new  String[]{itemId}, null, null, sortOrder);
                break;
            default:
        }

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        int row = 0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                row = db.update(MyDBhelper.TABLENAME_BOOK,values, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);

                row = db.update(MyDBhelper.TABLENAME_BOOK,values, "id=?", new String[]{bookId});
                break;
            default:
        }
        return row;
    }
}