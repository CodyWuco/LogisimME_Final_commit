package com.gamecodeschool.logicsimulator;

import android.graphics.PointF;

abstract class ObjectSpecific {
    //private String nTag;
    private String nBitmapName;
    //private float speed; //won't need it
    private PointF sizeScale;
    private String[] nComponents;

    //ObjectSpecific() {}

    ObjectSpecific(String bitmapName, PointF relativeScale, String[] components) {
        //nTag = tag;
        nBitmapName = bitmapName;
        sizeScale = relativeScale;
        nComponents = components;
    }


    /*String getTag() {
        return nTag;
    }*/

    String getBitmapName() {
        return nBitmapName;
    }

    PointF getSizeScale() {
        return sizeScale;
    }

    String[] getComponents() {
        return nComponents;
    }

}
