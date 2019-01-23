package com.camp.bit.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public class TodoDbHelper extends SQLiteOpenHelper {

    // TODO 定义数据库名、版本；创建数据库

    public TodoDbHelper(Context context) {
        super(context, "todo", null, 1);
    }

    private static final String SQL_CREATE_TODO =
            "CREATE TABLE " + TodoContract.Notes.TABLE_NAME + "(" +
                    TodoContract.Notes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TodoContract.Notes.DATE + " LONG," +
                    TodoContract.Notes.STATE + " INTEGER," +
                    TodoContract.Notes.CONTEND + " TEXT)";

    private static final String SQL_DELETE_TODO =
            "DROP TABLE IF EXISTS " + TodoContract.Notes.TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
