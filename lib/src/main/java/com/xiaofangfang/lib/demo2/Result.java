package com.xiaofangfang.lib.demo2;

import java.util.List;

public class Result {

    public List<DataO> data;

    public Result(List<DataO> data) {
        this.data = data;
    }

    public Result() {
    }

    public List<DataO> getData() {
        return data;
    }

    public void setData(List<DataO> data) {
        this.data = data;
    }
}
