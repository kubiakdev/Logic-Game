package com.example.robert.smilesad;

import android.view.View;

/**
 * Created by Robert on 2017-04-15.
 */

public class Inheritance {

    View view;
    View v;
    ObjectFeatures currentObjectFeatures = null;
    FieldFeatures currentFieldFeatures = null;

    Inheritance(View view, View v) {
        this.view = view;
        this.v = v;
        if (v == Board.y1x1) currentFieldFeatures = GetFeatures.y1x1Features;
        else if (v == Board.y1x2) currentFieldFeatures = GetFeatures.y1x2Features;
        else if (v == Board.y1x3) currentFieldFeatures = GetFeatures.y1x3Features;
        else if (v == Board.y2x1) currentFieldFeatures = GetFeatures.y2x1Features;
        else if (v == Board.y2x2) currentFieldFeatures = GetFeatures.y2x2Features;
        else if (v == Board.y2x3) currentFieldFeatures = GetFeatures.y2x3Features;
        else if (v == Board.y3x1) currentFieldFeatures = GetFeatures.y3x1Features;
        else if (v == Board.y3x2) currentFieldFeatures = GetFeatures.y3x2Features;
        else if (v == Board.y3x3) currentFieldFeatures = GetFeatures.y3x3Features;
        inheritFirstLevel(view);
        inheritSecondLevel(currentObjectFeatures, currentFieldFeatures);
    }

    public void inheritFirstLevel(View view) {
        if (view == Board.bbbb) currentObjectFeatures = GetFeatures.bbbbFeatures;
        else if (view == Board.bbbbx2) currentObjectFeatures = GetFeatures.bbbbx2Features;
        else if (view == Board.bbbbx3) currentObjectFeatures = GetFeatures.bbbbx3Features;
        else if (view == Board.brbr) currentObjectFeatures = GetFeatures.brbrFeatures;
        else if (view == Board.brbrx2) currentObjectFeatures = GetFeatures.brbrx2Features;
        // need add more
    }

    public void inheritSecondLevel(ObjectFeatures objectFeatures, FieldFeatures fieldFeatures) {
        if (fieldFeatures.enabled && !fieldFeatures.occupied) {
            //fieldFeatures.image =
            fieldFeatures.occupied = true;
            fieldFeatures.colorTop = objectFeatures.colorTop;
            fieldFeatures.colorBottom = objectFeatures.colorBottom;
            fieldFeatures.colorLeft = objectFeatures.colorLeft;
            fieldFeatures.colorRight = objectFeatures.colorRight;
            objectFeatures.used = true;
            objectFeatures.positionX = fieldFeatures.positionX;
            objectFeatures.positionY = fieldFeatures.positionY;
            backFromInherit(objectFeatures, fieldFeatures);
        } else Board.backToLastPosition();
    }

    public void backFromInherit(ObjectFeatures objectFeatures, FieldFeatures fieldFeatures) {
        if (fieldFeatures.name.equals(GetFeatures.y1x1Features)) GetFeatures.y1x1Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y1x2Features)) GetFeatures.y1x2Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y1x3Features)) GetFeatures.y1x3Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y2x1Features)) GetFeatures.y2x1Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y2x2Features)) GetFeatures.y2x2Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y2x3Features)) GetFeatures.y2x3Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y3x1Features)) GetFeatures.y3x1Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y3x2Features)) GetFeatures.y3x2Features = fieldFeatures;
        else if (fieldFeatures.name.equals(GetFeatures.y3x3Features)) GetFeatures.y3x3Features = fieldFeatures;

        if (objectFeatures.name.equals(GetFeatures.bbbbFeatures)) GetFeatures.bbbbFeatures = objectFeatures;
        else if (objectFeatures.name.equals(GetFeatures.bbbbx2Features)) GetFeatures.bbbbx2Features = objectFeatures;
        else if (objectFeatures.name.equals(GetFeatures.bbbbx3Features)) GetFeatures.bbbbx3Features = objectFeatures;
        else if (objectFeatures.name.equals(GetFeatures.brbrFeatures)) GetFeatures.brbrFeatures = objectFeatures;
        else if (objectFeatures.name.equals(GetFeatures.brbrx2Features)) GetFeatures.brbrx2Features = objectFeatures;
    }
}