package com.witcher.androidrss.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThemeData {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("title")
    @Expose
    private String title;

    public ThemeData() {
    }

    public ThemeData(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
