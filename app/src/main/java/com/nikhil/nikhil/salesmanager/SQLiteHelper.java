package com.nikhil.salesmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by NIKHIL on 18-01-2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
/*  We are creating a java file called SQLiteHelper and extending SQLiteOpenHelper class and It is used to create a bridge between android and SQLite.
    To perform basic SQL operations we need to extend SQLiteOpenHelper class.*/

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ItemDetails.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static final String TABLE_NAME1 = "ITEMS";
    public static final String COLUMN_ITEM_ID = "ITEM_ID";
    public static final String COLUMN_ITEM_NAME = "ITEM_NAME";
    public static final String COLUMN_ITEM_CATEGORY = "ITEM_CATEGORY";
    public static final String COLUMN_ITEM_PRICE = "ITEM_PRICE";
    public static final String COLUMN_ITEM_QUANTITY = "ITEM_QUANTITY";
    public static final String COLUMN_ITEM_SALES = "ITEM_SALES";

    public static final String TABLE_NAME2 = "LOG";
    public static final String COLUMN_DATE = "DATE";

    private SQLiteDatabase database;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME1 + " ( " + COLUMN_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ITEM_NAME + " VARCHAR, " + COLUMN_ITEM_CATEGORY + " VARCHAR, " + COLUMN_ITEM_PRICE + " FLOAT(4,2), " + COLUMN_ITEM_QUANTITY + " INTEGER, " + COLUMN_ITEM_SALES + " FLOAT(6,2));");

        db.execSQL("CREATE TABLE " + TABLE_NAME2 + " ( " + COLUMN_ITEM_ID + " INTEGER ," + COLUMN_DATE + " DATE, " + COLUMN_ITEM_QUANTITY + " INTEGER, " + COLUMN_ITEM_SALES + " FLOAT(6,2), FOREIGN KEY (" + COLUMN_ITEM_ID + ") REFERENCES " + TABLE_NAME1 + "(" + COLUMN_ITEM_ID + "));");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

/*    public void insertItem(ItemModel item) {

        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_ITEM_ID, item.getId());
        contentValues.put(COLUMN_ITEM_NAME, item.getItemName());
        contentValues.put(COLUMN_ITEM_CATEGORY, item.getCatgeory());
        contentValues.put(COLUMN_ITEM_PRICE, item.getPrice());
        contentValues.put(COLUMN_ITEM_QUANTITY, item.getQuantity());
        contentValues.put(COLUMN_ITEM_SALES, item.getSales());

        database.insert(TABLE_NAME1, null, contentValues);
        database.close();
    }*/

    public void insertItem(ItemModel item){

        database = this.getReadableDatabase();
        database.execSQL("INSERT INTO " + TABLE_NAME1 + "(" + COLUMN_ITEM_NAME + "," + COLUMN_ITEM_CATEGORY + "," + COLUMN_ITEM_PRICE + "," + COLUMN_ITEM_QUANTITY + "," + COLUMN_ITEM_SALES + ") VALUES('" + item.getItemName() + "','" + item.getCatgeory() + "','" + item.getPrice() + "','" + item.getQuantity()  + "','" + item.getSales()  + "')");
        database.close();

    }

    public void removeItem(String itemName){


        database = this.getReadableDatabase();
//        database.execSQL("INSERT INTO " + TABLE_NAME1 + "(" + COLUMN_ITEM_NAME + "," + COLUMN_ITEM_CATEGORY + "," + COLUMN_ITEM_PRICE + "," + COLUMN_ITEM_QUANTITY + "," + COLUMN_ITEM_SALES + ") VALUES('" + item.getItemName() + "','" + item.getCatgeory() + "','" + item.getPrice() + "','" + item.getQuantity()  + "','" + item.getSales()  + "')");
        database.close();
//        database.delete()


    }



/*  TODO: CHECK AFTER DONE
    public void insertLog(ItemModel item) {

        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        Calendar date = Calendar.getInstance();
        int yy = date.get(Calendar.YEAR);
        int mm = date.get(Calendar.MONTH);
        int dd = date.get(Calendar.DAY_OF_MONTH);

        String strDate = Integer.toString(yy) + "-" + Integer.toString(mm) + "-" + Integer.toString(dd);

        contentValues.put(COLUMN_ITEM_ID, item.getId());
        contentValues.put(COLUMN_DATE, strDate);
        contentValues.put(COLUMN_ITEM_QUANTITY, item.getQuantity());
        contentValues.put(COLUMN_ITEM_SALES, item.getSales());


        database.insert(TABLE_NAME2, null, contentValues);
        database.close();


    }
*/

}
