package com.gamecodeschool.logicsimulator;

import android.graphics.PointF;

class Transform {
    // for scrolling background
    private int xClip;
    private boolean reversed = false;

    //private PointF location;
    private static PointF screenSize;

    Transform(PointF screenSize) {
        //location = startingLocation;
        this.screenSize = screenSize;
    }

    int getXClip(){
        return xClip;
    }

    void setXClip(int newXClip){
        xClip = newXClip;
    }

    void flipReversedFirst(){
        reversed = !reversed;
    }

    PointF getmScreenSize(){
        return screenSize;
    }

}

