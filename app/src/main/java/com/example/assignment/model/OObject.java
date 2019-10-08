package com.example.assignment.model;

public class OObject {
    String id;
    String nameClass;

    public static final String TABLE_CLASS = "OObject";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";


    public static final String CREATE_TABLE_CLASS = " CREATE TABLE " + TABLE_CLASS + "(" + COLUMN_ID +
            " INTEGER PRIMARY KEY ," + COLUMN_NAME + " VARCHAR) ";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }



}