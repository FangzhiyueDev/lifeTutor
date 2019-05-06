package com.example.momomusic.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MusicDataDb {

    private DaoHelper daoHelper;

    public static final String TABLE_SCHEMA = "table_schema";

    private static MusicDataDb musicDataDb;


    public static final String TABLE_1 = "music";


    private MusicDataDb(Context context) {
        if (daoHelper == null) {
            daoHelper = new DaoHelper(context, null, null, -1);
        }
    }

    /**
     * 获得当前的
     *
     * @param context
     * @return
     */
    public static MusicDataDb getInstance(Context context) {
        if (musicDataDb == null) {
            musicDataDb = new MusicDataDb(context);
        }
        return musicDataDb;
    }


    public List<String> queryTable() {


        List<String> names = new ArrayList<>();

        SQLiteDatabase sql = daoHelper.getReadableDatabase();
        Cursor cursor = sql.query(TABLE_SCHEMA, new String[]{TableSchema.NAME}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            names.add(name);
        }
        return names;
    }

    public void createTable(String table) {
        SQLiteDatabase sql = daoHelper.getReadableDatabase();
        sql.execSQL("create table " + table + "(" +
                "id int primary key autoincrement," +
                "dataUrl varchar not null," +
                "FOREIGN KEY(dataUrl) REFERENCES music(dataUrl)) ON UPDATE CASCADE ON DELETE CASCADE");
    }

    public void insertData(String table, List<String> dataUrl) {
        SQLiteDatabase sql = daoHelper.getReadableDatabase();
        sql.beginTransaction();
        for (int i = 0; i < dataUrl.size(); i++) {
            ContentValues cv = new ContentValues();
            cv.put(TableMusic.DATA_URL, dataUrl.get(i));
            sql.insert(table, null, cv);
        }
        sql.endTransaction();
    }


    class TableSchema {
        public static final String NAME = "name";

    }

    class TableMusic {
        public static final String DATA_URL = "dataUrl";
    }


    /**
     * 查询新建的歌单
     *
     * @return
     */
    public List<String> queryNewMusicSheet() {
        List<String> tables = queryTable();
        tables.remove(TABLE_1);
        return tables;
    }


}
