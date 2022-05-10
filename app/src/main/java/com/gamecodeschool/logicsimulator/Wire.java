package com.gamecodeschool.logicsimulator;

import java.lang.Math;
/*
 * In Wire, the logic for producing a taxicab route is made.
 *
 */
public class Wire extends WireMath {
    private float x0,y0,x1,y1;
    private int strokeWidth;

    public Wire(float x0, float y0, float x1, float y1)
               {this.x0=x0; this.y0=y0; this.x1=x1; this.y1=y1; strokeWidth=1;}
    public WireMath wireMath;

    int x = wireMath.midPointX();
    int y = wireMath.midPointY();


}
