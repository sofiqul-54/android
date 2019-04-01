package com.sofiqul54.sqlightexm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyDbAdapter {
    MyDbHelper helper;

    /**/ Context context;

    public MyDbAdapter(Context context) {
        this.helper = new MyDbHelper(context);
    }

    static class MyDbHelper extends SQLiteOpenHelper {
        static final String DB_NAME = "PROD.DB";
        static final int DB_VERSION = 1;

        public MyDbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public static final String TABLE_NAME = "PRODUCT";
        public static final String ID = "id";
        private static final String PRODUCT_NAME = "product_name";
        private static final String QTY = "qty";

        private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PRODUCT_NAME + "TEXT NOT NULL," + QTY + "INTEGER NOT NULL)";

      /*  public MyDbHelper(Context context) {
            super(context);
        }*/

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public long insertData(Product product) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.PRODUCT_NAME, product.getProductName());
        contentValues.put(MyDbHelper.QTY, product.getQuantity());
        long id = db.insert(MyDbHelper.TABLE_NAME, null, contentValues);
        return id;

    }

    public Product findProductById(int id) {

        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {MyDbHelper.ID, MyDbHelper.PRODUCT_NAME, MyDbHelper.QTY};
        String selection = MyDbHelper.ID + "=" + id;
        Cursor cursor = db.query(MyDbHelper.TABLE_NAME, projection, selection,null,null,null, null
        );
        Product product = new Product();
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            product.setId(Integer.parseInt(cursor.getString(0)));
            product.setProductName(cursor.getString(1));
            product.setQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }else {
            product = null;
        }
        return product;

    }

    public  List<Product> getlist(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {MyDbHelper.ID, MyDbHelper.PRODUCT_NAME, MyDbHelper.QTY};
        Cursor cursor = db.query(MyDbHelper.TABLE_NAME, projection, null,null,null,null, null
        );
        List<Product> list = new ArrayList<>();
        while (cursor.moveToNext()){
            Product product
        }
    }

    public void deleteProduct(int id){
        SQLiteDatabase db = helper.getWritableDatabase();
       db.execSQL("DELETE FROM " + MyDbHelper.TABLE_NAME + "WHERE" + MyDbHelper.ID + "='" + id+"'");
       db.close();
    }



}
