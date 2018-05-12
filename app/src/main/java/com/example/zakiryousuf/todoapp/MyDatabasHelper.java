package com.example.zakiryousuf.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by Zakir Yousuf on 31/03/2018.
 */

public class MyDatabasHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="tasks.db";
    public static final String TABLE_TASKS="tasks";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_TASKSNAME="taskname";

    public MyDatabasHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query= "CREATE TABLE " + TABLE_TASKS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASKSNAME + " TEXT " +");";
        db.execSQL(query);
    }

    public void addTasks(Tasks tasks){
        ContentValues values=new ContentValues();
        values.put(COLUMN_TASKSNAME,tasks.get_taskname());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_TASKS,null,values);
        db.close();

    }
    public void removeTask(String taskname){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_TASKS + " WHERE " + COLUMN_TASKSNAME + "=\"" + taskname +"\";");

    }

    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM " + TABLE_TASKS + " WHERE 1";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("taskname"))!=null){
                dbString +=c.getString(c.getColumnIndex("taskname"));
                dbString +="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TASKS);
        onCreate(db);
    }
}
