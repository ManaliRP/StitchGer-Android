package com.example.admin1.stitchger_android.model;

public class HomeItem {
    public String name, style, date;
    public HomeItem(String name, String style, String date){
        this.name = name;
        this.style = style;
        this.date = date;
    }
    public HomeItem(){

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }
}
