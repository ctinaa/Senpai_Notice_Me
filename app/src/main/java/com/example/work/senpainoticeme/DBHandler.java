package com.example.work.senpainoticeme;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

/**
 * Created by Work on 3/13/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    /* saving info to a file; use .db */
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMNN_PRODUCTNAME = "productname";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMNN_PRODUCTNAME + " TEXT " +
                ");";
        db.execSQL(query);
    /*execute SQL query - the onCreate */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP_TABLE_IF_EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }
    // add a new row to the database
    public void addProduct(Product product) {
        ContentValues values = new ContentValues();
        values.put(COLUMNN_PRODUCTNAME, product.get_productname());
        // ContentValues: set values for col in one statement
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values); // takes 3 parameters
        db.close();
    }

    // delete product from the database
    public void deleteProduct(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + "WHERE" + COLUMNN_PRODUCTNAME + "=\"" + productName + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1"; // 1  = all conditions met
        // Cursor points to location to results
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){

        }
    }

}