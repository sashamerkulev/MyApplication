package ru.merkulyevsasha.recyclerviews.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

public class Obj implements Serializable {

    private List<Video> videos;

    public Obj(List<Video> videos){
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
