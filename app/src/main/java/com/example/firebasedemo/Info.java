package com.example.firebasedemo;

import android.widget.EditText;

public class Info {
    private String id;
    private String name,father_name;

    public Info() {
    }

    public Info(String id, String name, String fname){
       this.id=id;
       this.name=name;
       father_name=fname;
   }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }
}
