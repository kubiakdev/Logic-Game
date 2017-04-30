package com.example.robert.smilesad;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Robert on 2017-03-22.
 */

public class FieldFeatures {
    String name;
    RelativeLayout field;
    ImageView image;
    float positionX, positionY;
    String colorTop, colorBottom, colorLeft, colorRight;
    boolean occupied, enabled;

    FieldFeatures(String name, RelativeLayout field, ImageView image, boolean occupied, boolean enabled,
                  float positionY, float positionX,
                  String colorTop, String colorBottom, String colorLeft, String colorRight) {
        this.name = name;
        this.field = field;
        this.image = image;
        this.occupied = occupied;
        this.enabled = enabled;
        this.positionY = positionY;
        this.positionX = positionX;
        this.colorTop = colorTop;
        this.colorBottom = colorBottom;
        this.colorLeft = colorLeft;
        this.colorRight = colorRight;
    }
}