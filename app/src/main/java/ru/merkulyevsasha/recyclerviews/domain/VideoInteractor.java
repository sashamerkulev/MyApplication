package ru.merkulyevsasha.recyclerviews.domain;

import java.util.ArrayList;
import java.util.List;

import ru.merkulyevsasha.recyclerviews.pojo.Obj;
import ru.merkulyevsasha.recyclerviews.pojo.Video;
import ru.merkulyevsasha.recyclerviews.pojo.VideoItem;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

public class VideoInteractor {

    public VideoInteractor(){

    }

    public Obj getVideos(){
        List<VideoItem> items1 = new ArrayList<>();
        items1.add(new VideoItem("1+1", "2011"));
        items1.add(new VideoItem("12 лет рабства", "2013"));
        items1.add(new VideoItem("1408", "2007"));
        items1.add(new VideoItem("Настоящий детектив", "2014"));
        items1.add(new VideoItem("Рим", "2005"));

        List<VideoItem> items2 = new ArrayList<>();
        items2.add(new VideoItem("Игра престолов", "2011"));
        items2.add(new VideoItem("Быть Флином", "2011"));
        items2.add(new VideoItem("8 Лучших Свиданий", "2016"));
        items2.add(new VideoItem("Авиатор", "2004"));
        items2.add(new VideoItem("Кэрол", "2016"));
        items2.add(new VideoItem("Экстрасенс", "2011"));
        items2.add(new VideoItem("Винил", "2016"));

        List<VideoItem> items3 = new ArrayList<>();
        items3.add(new VideoItem("Экипаж", "2016"));
        items3.add(new VideoItem("Битва за севастополь", "2015"));
        items3.add(new VideoItem("Вице-президент", "2012"));
        items3.add(new VideoItem("Анна Каренина", "201967"));
        items3.add(new VideoItem("Друзья", "1994"));

        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Meggogo", items1));
        videos.add(new Video("Amedia", items2));
        videos.add(new Video("Ivi", items3));

        return new Obj(videos);
    }

}
