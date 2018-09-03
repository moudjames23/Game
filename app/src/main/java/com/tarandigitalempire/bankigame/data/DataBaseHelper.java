package com.tarandigitalempire.bankigame.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String CREATE_TABLE_THEME = "CREATE TABLE "
            + Constant.THEME_TABLE + " ( "
            + Constant.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constant.COLUMN_THEME_NAME +" TEXT ,"
            + Constant.COLUMN_THEME_DATE + " DATETIME "
            + ")";

    public DataBaseHelper(Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_THEME);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Constant.THEME_TABLE);
        onCreate(db);
    }

    public Cursor getThemes(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = " SELECT * FROM " + Constant.THEME_TABLE + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor;
    }
}
