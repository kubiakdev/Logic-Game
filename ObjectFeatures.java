package com.example.robert.smilesad;

import android.widget.ImageView;

/**
 * Created by Robert on 2017-03-22.
 */

public class ObjectFeatures {

    String name;
    ImageView imageView;
    boolean used;
    float positionX, positionY;
    String colorTop, colorBottom, colorLeft, colorRight;

    ObjectFeatures(String name, ImageView imageView, boolean used, float positionY, float positionX,
                   String colorTop, String colorBottom, String colorLeft, String colorRight) {
        this.name = name;
        this.imageView = imageView;
        this.used = used;
        this.positionY = positionY;
        this.positionX = positionX;
        this.colorTop = colorTop;
        this.colorBottom = colorBottom;
        this.colorLeft = colorLeft;
        this.colorRight = colorRight;
    }
}