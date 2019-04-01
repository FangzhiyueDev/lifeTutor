package com.xiaofangfang.lib;

import java.util.List;

public class Result {

    private List<Song> songList;
    private String result;

    public Result(List<Song> songList, String result) {
        this.songList = songList;
        this.result = result;
    }

    public Result() {
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
