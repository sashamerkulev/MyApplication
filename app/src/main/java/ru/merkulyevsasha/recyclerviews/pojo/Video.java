package ru.merkulyevsasha.recyclerviews.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

public class Video implements Serializable{

    private String videoName;
    private List<VideoItem> items;

    public Video(String name, List<VideoItem> items){
        this.videoName = name;
        this.items = items;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public List<VideoItem> getItems() {
        return items;
    }

    public void setItems(List<VideoItem> items) {
        this.items = items;
    }
}
