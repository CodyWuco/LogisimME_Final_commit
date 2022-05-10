package com.gamecodeschool.logicsimulator;

import android.view.MotionEvent;

import java.lang.Math;

public class WireMath {

    MotionEvent motionEvent;
    public int midPointInitialComponentX() {
        //int x = (int)motionEvent.getX();
        return -1;
    }
    public int midPointInitialComponentY() {
        //int y = (int)motionEvent.getY();
        return -1;
    }
    //---------------FINAL-------------------------\\
    public int midPointFinalComponentX() {
        //int x = (int)motionEvent.getX();
        return -1;
    }
    public int midPointFinalComponentY()
    {
        //int y = (int)motionEvent.getY();
        return -1;
    }
    //CAN USE MIDPOINT TO DO (X,NULL), (NULL,Y)
    //---------------MIDPOINT----------------------\\   //can use
    public int midPointX(){
        //int x = ((midPointInitialComponentX()+midPointFinalComponentX())/2);
        return -1;
    }

    public int midPointY(){
        //int y = ((midPointInitialComponentY()+midPointFinalComponentY())/2);
        return -1;
    }
    //------------------------------------------------------\\
    //true midpoint
    public int midPointXY(){
        //int x = midPointX()*midPointY();
        return -1; //not sure if needed
    }
    //---------------MOVE--------------------------\\
    public float moveEventX(float x) {return x;}
    public float moveEventY(float y) {return y;}
    //---------------HYPOTENUSE--------------------\\
    public int hypotenuseX(){
        //a^2 + b^2 = c^2
        //have values of each X/Y
        int hyp = (int)Math.sqrt((midPointX()*midPointX()));
        return hyp; //change later
    }
    public int hypotenuseY(){
        int hyp = (int)Math.sqrt((midPointY()*midPointY()));
        return hyp;
    }
    public int hypotenuseXY(){
        //a^2 + b^2 = c^2
        //have values of each X/Y
        int hyp = (int)Math.sqrt((midPointXY()*midPointXY()));
        return hyp;
    }
//------------------------------------------------------\\

}
