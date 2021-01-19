package com.yl.learn.dp.observer;

import com.yl.learn.dp.observer.imp.Observer;
import com.yl.learn.util.util.PrintUtil;

public class ObserverA implements Observer {
    @Override
    public void update() {
        PrintUtil.println("update");
    }
}
