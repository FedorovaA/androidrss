package com.witcher.androidrss.domain;

import java.time.LocalDateTime;

public class News {

    private Long id;
    private String linkNews;
    private String linkIcon;
    private LocalDateTime datePublication;

    public News(Long id, String linkNews, String linkIcon, LocalDateTime datePublication) {
        this.id = id;
        this.linkNews = linkNews;
        this.linkIcon = linkIcon;
        this.datePublication = datePublication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkNews() {
        return linkNews;
    }

    public void setLinkNews(String linkNews) {
        this.linkNews = linkNews;
    }

    public String getLinkIcon() {
        return linkIcon;
    }

    public void setLinkIcon(String linkIcon) {
        this.linkIcon = linkIcon;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }
}
