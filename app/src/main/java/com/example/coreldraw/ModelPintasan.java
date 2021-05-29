package com.example.coreldraw;

public class ModelPintasan {
    String title;
    String desc;
    String key;
    int icon;

    public ModelPintasan(String title, String desc){
        this.title = title;
        this.desc = desc;
        this.key = key;
        this.icon = icon;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getKey() {
        return this.key;
    }

    public int getIcon() {
        return this.icon;
    }
}
