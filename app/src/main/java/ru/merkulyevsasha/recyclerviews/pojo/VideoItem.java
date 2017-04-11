package ru.merkulyevsasha.recyclerviews.pojo;

import java.io.Serializable;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

public class VideoItem implements Serializable {

    private String title;
    private String year;

    public VideoItem(String title, String year){
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
