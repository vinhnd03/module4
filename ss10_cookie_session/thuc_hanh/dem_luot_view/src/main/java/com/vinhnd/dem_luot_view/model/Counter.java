package com.vinhnd.dem_luot_view.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


public class Counter {
    private int count;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }
}
