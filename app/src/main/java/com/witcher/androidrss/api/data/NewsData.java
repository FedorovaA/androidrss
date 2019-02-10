package com.witcher.androidrss.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class NewsData {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("linkNews")
    @Expose
    private String linkNews;

    @SerializedName("linkIcon")
    @Expose
    private String linkIcon;

    @SerializedName("datePublication")
    @Expose
    private LocalDateTime datePublication;

    public NewsData() {
    }

    public NewsData(Long id, String linkNews, String linkIcon, LocalDateTime datePublication) {
        this.id = id;
        this.linkNews = linkNews;
        this.linkIcon = linkIcon;
        this.datePublication = datePublication;
    }

    public Long getId() {
        return id;
    }

    public String getLinkNews() {
        return linkNews;
    }

    public String getLinkIcon() {
        return linkIcon;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }
}
