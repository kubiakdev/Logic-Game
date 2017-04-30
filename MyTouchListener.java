package com.example.robert.smilesad;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Robert on 2017-04-16.
 */
public final class MyTouchListener implements View.OnTouchListener {

    static ObjectFeatures touchedObject;
    static RelativeLayout draggedField;

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            touchedObject = Operations.getTouchedObject(view);
            draggedField = Operations.getDraggedField(touchedObject);
            if (Operations.isThisObjectUsed(view)){
                Operations.setUsedFieldToFalse(touchedObject,draggedField);
            }
            return true;
        } else {
            return false;
        }
    }
}