package com.example.quanlynhathuoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    private static String DB_NAME = "dbNhaThuoc.db";
    private static int DB_VERSION =1;
    private static final String TB_NHATHUOCS = "tbNhaThuoc";
    private static final String COL_NHATHUOC_MANT = "NhaThuoc_MaNT";
    private static final String COL_NHATHUOC_TENNT = "NhaThuoc_TenNT";
    private static final String COL_NHATHUOC_DIACHI = "NhaThuoc_DiaChi";

    public database(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ TB_NHATHUOCS);
        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String scriptTB_NhaThuocs = "CREATE TABLE "+ TB_NHATHUOCS +"("+ COL_NHATHUOC_MANT + " TEXT PRIMARY KEY,"
                + COL_NHATHUOC_TENNT + " TEXT," + COL_NHATHUOC_DIACHI + " TEXT)";
        db.execSQL(scriptTB_NhaThuocs);
    }
    public void getAllData(ArrayList<nhaThuoc> nhaThuocs)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TB_NHATHUOCS, new String[]{
                COL_NHATHUOC_MANT,COL_NHATHUOC_TENNT,COL_NHATHUOC_DIACHI},null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                nhaThuoc nt = new nhaThuoc();
                nt.setMaNT(cursor.getString(cursor.getColumnIndex(COL_NHATHUOC_MANT)));
                nt.setTenNT(cursor.getString(cursor.getColumnIndex(COL_NHATHUOC_TENNT)));
                nt.setDiaChi(cursor.getString(cursor.getColumnIndex(COL_NHATHUOC_DIACHI)));
                nhaThuocs.add(nt);
            } while (cursor.moveToNext());

        }
    }
    public void saveNhaThuoc(nhaThuoc nt)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NHATHUOC_MANT,nt.getMaNT());
        values.put(COL_NHATHUOC_TENNT,nt.getTenNT());
        values.put(COL_NHATHUOC_DIACHI,nt.getDiaChi());
        db.insert(TB_NHATHUOCS,null,values);
        db.close();
    }
    public void deleteNhaThuoc(String maNT)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TB_NHATHUOCS + " WHERE " + COL_NHATHUOC_MANT + "= " + maNT;
        db.execSQL(query);
    }
    public void updateNhaThuoc(nhaThuoc nt)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql ="UPDATE "+TB_NHATHUOCS +" set ";
        sql += COL_NHATHUOC_TENNT +"='"+nt.getMaNT()+"',";
        sql += COL_NHATHUOC_DIACHI +"='"+nt.getDiaChi()+"' ";
        sql += " WHERE " + COL_NHATHUOC_MANT +"='"+nt.getMaNT();
        db.execSQL(sql);
    }
}
