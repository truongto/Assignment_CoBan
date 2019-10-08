package com.example.assignment.model;

public class Student {
    String id;
    String name;
    String  birthday;

    public static final String TABLE_STUDENT = "Student";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public  static final String COLUMN_BIRTHDAY="birthday";

    public static final String CREATE_TABLE_STUDENT = " CREATE TABLE " + TABLE_STUDENT + "(" + COLUMN_ID +
            " INTEGER PRIMARY KEY, " + COLUMN_NAME + " VARCHAR, " + COLUMN_BIRTHDAY + " VARCHAR) ";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



}
