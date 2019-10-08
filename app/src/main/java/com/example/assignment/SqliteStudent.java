package com.example.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment.model.OObject;
import com.example.assignment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SqliteStudent extends SQLiteOpenHelper {
    public SqliteStudent(Context contex) {
        super(contex, "Student.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(OObject.CREATE_TABLE_CLASS);
        db.execSQL(Student.CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + OObject.TABLE_CLASS);
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_STUDENT);
        onCreate(db);

    }

    public long inserClass(OObject aClass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OObject.COLUMN_ID, aClass.getId());
        contentValues.put(OObject.COLUMN_NAME, aClass.getNameClass());
        long result = sqLiteDatabase.insert(OObject.TABLE_CLASS, null, contentValues);
        sqLiteDatabase.close();
        return result;

    }

    public List<OObject> getAllClass() {
        List<OObject> students = new ArrayList<>();
        String SELECT = " SELECT * FROM " + OObject.TABLE_CLASS;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(OObject.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(OObject.COLUMN_NAME));
                OObject student = new OObject();
                student.setId(id);
                student.setNameClass(name);
                students.add(student);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return students;
    }

    public long deleteClass(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(OObject.TABLE_CLASS, OObject.COLUMN_ID + "=?", new String[]{id});
    }




    public long inserStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.COLUMN_ID, student.getId());
        contentValues.put(Student.COLUMN_NAME, student.getName());
        contentValues.put(Student.COLUMN_BIRTHDAY, student.getBirthday());
        long result = sqLiteDatabase.insert(Student.TABLE_STUDENT, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String SELECT = " SELECT * FROM " + Student.TABLE_STUDENT;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(Student.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(Student.COLUMN_NAME));
                String birthday = cursor.getString(cursor.getColumnIndex(Student.COLUMN_BIRTHDAY));
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setBirthday(birthday);
                students.add(student);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return students;
    }

    public long deleteStudent(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(Student.TABLE_STUDENT, OObject.COLUMN_ID + "=?", new String[]{id});
    }


}
