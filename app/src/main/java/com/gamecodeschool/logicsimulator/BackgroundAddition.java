package com.gamecodeschool.logicsimulator;

import android.graphics.PointF;

class BackgroundAddition extends ObjectSpecific {
    //private static final String tag = "Background";
    private static final String bitmapName = "background1"; // make this the second grid screen
    private static final PointF relativeScale = new PointF(1f,1f);
    private static final String[] components = new String [] {
            "BackgroundGraphicsComponent",
            "BackgroundMovementComponent",
            "BackgroundSpawnComponent"};

    BackgroundAddition() {
        super(bitmapName, relativeScale, components);
    }


}
