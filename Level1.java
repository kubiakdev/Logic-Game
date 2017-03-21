package com.example.robert.smilesad;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class Level1 extends Activity {
    private static ImageView object1, object2, object3, object4, object5, object6, object7, object8, object9;
    private static RelativeLayout currentStick, field1, field2, field3, field4, field5, field6, field7, field8, field9, activity;
    private static ImageView prevoriousObject, currentObject;
    private static final String IMAGEVIEW_TAG = "The Android Logo";
    private RelativeLayout leftButton, rightButton;
    private static ArrayList<ImageView> objects = new ArrayList<>(9);
    private static View.DragShadowBuilder shadowBuilder;
    private static boolean MAINTEST = false;

    static ObjectFeatures defaultObjectFeatures = new ObjectFeatures(null, false,
            0, 0, "no color", "no color", "no color", "no color");
    static ObjectFeatures bbbbFeatures = new ObjectFeatures(object1, false,
            0, 0, "blue", "blue", "blue", "blue");
    static ObjectFeatures bbbbx2Features = new ObjectFeatures(object2, false,
            0, 0, "blue", "blue", "blue", "blue");
    static ObjectFeatures rbrbFeatures = new ObjectFeatures(object3, false,
            0, 0, "red", "red", "blue", "blue");
    static ObjectFeatures rrbrFeatures = new ObjectFeatures(object4, false,
            0, 0, "red", "blue", "red", "red");
    static ObjectFeatures rrbrx2Features = new ObjectFeatures(object5, false,
            0, 0, "red", "blue", "red", "red");
    static ObjectFeatures brrrFeatures = new ObjectFeatures(object6, false,
            0, 0, "blue", "red", "red", "red");
    static ObjectFeatures brrrx2Features = new ObjectFeatures(object7, false,
            0, 0, "blue", "red", "red", "red");
    static ObjectFeatures rrrrFeatures = new ObjectFeatures(object8, false,
            0, 0, "red", "red", "red", "red");
    static ObjectFeatures rrrrx2Features = new ObjectFeatures(object9, false,
            0, 0, "red", "red", "red", "red");

    static FieldFeatures defaultFieldFeatures = new FieldFeatures(null, null, false, 0, 0,
            null, null, null, null);
    static FieldFeatures y3x1Features = new FieldFeatures(field1, null, false, 3, 1,
            null, null, null, null);
    static FieldFeatures y3x2Features = new FieldFeatures(field2, null, false, 3, 2,
            null, null, null, null);
    static FieldFeatures y3x3Features = new FieldFeatures(field3, null, false, 3, 3,
            null, null, null, null);
    static FieldFeatures y2x1Features = new FieldFeatures(field4, null, false, 2, 1,
            null, null, null, null);
    static FieldFeatures y2x2Features = new FieldFeatures(field5, null, false, 2, 2,
            null, null, null, null);
    static FieldFeatures y2x3Features = new FieldFeatures(field6, null, false, 2, 3,
            null, null, null, null);
    static FieldFeatures y1x1Features = new FieldFeatures(field7, null, false, 1, 1,
            null, null, null, null);
    static FieldFeatures y1x2Features = new FieldFeatures(field8, null, false, 1, 2,
            null, null, null, null);
    static FieldFeatures y1x3Features = new FieldFeatures(field9, null, false, 1, 3,
            null, null, null, null);

    private static boolean hTest1 = false;    // Test horizontal field1 - field2
    private static boolean hTest2 = false;    // Test horizontal field2 - field3
    private static boolean hTest3 = false;    // Test horizontal field4 - field5
    private static boolean hTest4 = false;    // Test horizontal field5 - field6
    private static boolean hTest5 = false;    // Test horizontal field7 - field8
    private static boolean hTest6 = false;    // Test horizontal field8 - field9

    private static boolean vTest1 = false;    // Test vertical field1 - field4
    private static boolean vTest2 = false;    // Test vertical field2 - field5
    private static boolean vTest3 = false;    // Test vertical field3 - field6
    private static boolean vTest4 = false;    // Test vertical field4 - field7
    private static boolean vTest5 = false;    // Test vertical field5 - field8
    private static boolean vTest6 = false;    // Test vertical field6 - field9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);


        currentStick = (RelativeLayout) findViewById(R.id.currentsticks);
        activity = (RelativeLayout) findViewById(R.id.activity_level1);

        field1 = (RelativeLayout) findViewById(R.id.l1_y3x1);
        field2 = (RelativeLayout) findViewById(R.id.l1_y3x2);
        field3 = (RelativeLayout) findViewById(R.id.l1_y3x3);
        field4 = (RelativeLayout) findViewById(R.id.l1_y2x1);
        field5 = (RelativeLayout) findViewById(R.id.l1_y2x2);
        field6 = (RelativeLayout) findViewById(R.id.l1_y2x3);
        field7 = (RelativeLayout) findViewById(R.id.l1_y1x1);
        field8 = (RelativeLayout) findViewById(R.id.l1_y1x2);
        field9 = (RelativeLayout) findViewById(R.id.l1_y1x3);


        currentStick.setOnDragListener(new MyDragListener());

        field1.setOnDragListener(new MyDragListener());
        field2.setOnDragListener(new MyDragListener());
        field3.setOnDragListener(new MyDragListener());
        field4.setOnDragListener(new MyDragListener());
        field5.setOnDragListener(new MyDragListener());
        field6.setOnDragListener(new MyDragListener());
        field7.setOnDragListener(new MyDragListener());
        field8.setOnDragListener(new MyDragListener());
        field9.setOnDragListener(new MyDragListener());


        object1 = (ImageView) findViewById(R.id.bbbb);
        object2 = (ImageView) findViewById(R.id.bbbbx2);
        object3 = (ImageView) findViewById(R.id.rbrb);
        object4 = (ImageView) findViewById(R.id.rrbr);
        object5 = (ImageView) findViewById(R.id.rrbrx2);
        object6 = (ImageView) findViewById(R.id.brrr);
        object7 = (ImageView) findViewById(R.id.brrrx2);
        object8 = (ImageView) findViewById(R.id.rrrr);
        object9 = (ImageView) findViewById(R.id.rrrrx2);


        object1.setTag(IMAGEVIEW_TAG);
        object2.setTag(IMAGEVIEW_TAG);
        object3.setTag(IMAGEVIEW_TAG);
        object4.setTag(IMAGEVIEW_TAG);
        object5.setTag(IMAGEVIEW_TAG);
        object6.setTag(IMAGEVIEW_TAG);
        object7.setTag(IMAGEVIEW_TAG);
        object8.setTag(IMAGEVIEW_TAG);
        object9.setTag(IMAGEVIEW_TAG);


        object1.setOnTouchListener(new MyClickListener());
        object2.setOnTouchListener(new MyClickListener());
        object3.setOnTouchListener(new MyClickListener());
        object4.setOnTouchListener(new MyClickListener());
        object5.setOnTouchListener(new MyClickListener());
        object6.setOnTouchListener(new MyClickListener());
        object7.setOnTouchListener(new MyClickListener());
        object8.setOnTouchListener(new MyClickListener());
        object9.setOnTouchListener(new MyClickListener());


        objects.add(object1);
        objects.add(object2);
        objects.add(object3);
        objects.add(object4);
        objects.add(object5);
        objects.add(object6);
        objects.add(object7);
        objects.add(object8);
        objects.add(object9);


        prevoriousObject = objects.get(0);
        object1.setVisibility(View.VISIBLE);
        currentObject = objects.get(0);

        leftButton = (RelativeLayout) findViewById(R.id.nextsticksleft);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevoriousObject.setVisibility(View.GONE);
                if (prevoriousObject == objects.get(0)) {
                    currentObject = objects.get(objects.size() - 1);
                    currentObject.setVisibility(View.VISIBLE);
                } else {
                    currentObject = objects.get(objects.indexOf(prevoriousObject) - 1);
                    currentObject.setVisibility(View.VISIBLE);
                }
                prevoriousObject = currentObject;
            }
        });
        rightButton = (RelativeLayout) findViewById(R.id.nextsticksright);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevoriousObject.setVisibility(View.GONE);
                if (prevoriousObject == objects.get(objects.size() - 1)) {
                    currentObject = objects.get(0);
                    currentObject.setVisibility(View.VISIBLE);
                } else {
                    currentObject = objects.get(objects.indexOf(prevoriousObject) + 1);
                    currentObject.setVisibility(View.VISIBLE);
                }
                prevoriousObject = currentObject;
            }
        });
    }

    private final class MyClickListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
            String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
            shadowBuilder = new View.DragShadowBuilder(view);

            view.startDrag(data, //data to be dragged
                    shadowBuilder, //drag shadow
                    view, //local data about the drag and drop operation
                    0   //no needed flags
            );


            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            // Handles each of the expected events
            switch (event.getAction()) {
                //signal for the start of a drag and drop operation.
                case DragEvent.ACTION_DRAG_STARTED:
                    View start = (View) event.getLocalState();
                    if (start == currentStick) Toast.makeText(Level1.this, "stick", Toast.LENGTH_SHORT).show();
                    if (objects.size() > 1) {
                        if (prevoriousObject == objects.get(objects.size() - 1)) {
                            currentObject = objects.get(0);
                            currentObject.setVisibility(View.VISIBLE);
                        } else {
                            currentObject = objects.get(objects.indexOf(prevoriousObject) + 1);
                            currentObject.setVisibility(View.VISIBLE);
                        }
                    } else {
                        prevoriousObject = objects.get(0);
                        prevoriousObject.setVisibility(View.GONE);
                    }
                    break;
                //the drag point has entered the bounding box of the View
                case DragEvent.ACTION_DRAG_ENTERED:
                    //change the shape of the view
                    if (v == field1)
                        if (y3x1Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field2)
                        if (y3x2Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field3)
                        if (y3x3Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field4)
                        if (y2x1Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field5)
                        if (y2x2Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field6)
                        if (y2x3Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field7)
                        if (y1x1Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field8)
                        if (y1x2Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else if (v == field9)
                        if (y1x3Features.occupied) v.setBackgroundResource(R.drawable.badshape);
                        else v.setBackgroundResource(R.drawable.shape);
                    else v.setBackgroundResource(R.drawable.badshape);
                    break;
                //show current position
                case DragEvent.ACTION_DRAG_LOCATION:
                    break;
                //the user has moved the drag shadow outside the bounding box of the View
                case DragEvent.ACTION_DRAG_EXITED:
                    //change the shape of the view back to normal
                    v.setBackgroundResource(R.drawable.graybackground);
                    break;

                //drag shadow has been released,the drag point is within the bounding box of the View
                case DragEvent.ACTION_DROP:
                    // if the view is the bottomlinear, we accept the drag item

                    View view = (View) event.getLocalState();
                    ViewGroup viewgroup = (ViewGroup) view.getParent();
                    viewgroup.removeView(view);
                    RelativeLayout containView = (RelativeLayout) v;
                    containView.addView(view);
                    view.setVisibility(View.VISIBLE);

                    if ((v == field1) && (!y3x1Features.occupied) ||
                            (v == field2) && (!y3x2Features.occupied) ||
                            (v == field3) && (!y3x3Features.occupied) ||
                            (v == field4) && (!y2x1Features.occupied) ||
                            (v == field5) && (!y2x2Features.occupied) ||
                            (v == field6) && (!y2x3Features.occupied) ||
                            (v == field7) && (!y1x1Features.occupied) ||
                            (v == field8) && (!y1x2Features.occupied) ||
                            (v == field9) && (!y1x3Features.occupied)) {
                        if ((v == field1) && (!y3x1Features.occupied)) {
                            defaultFieldFeatures = y3x1Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y3x1Features = defaultFieldFeatures;
                        } else if ((v == field2) && (!y3x2Features.occupied)) {
                            defaultFieldFeatures = y3x2Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y3x2Features = defaultFieldFeatures;
                        } else if ((v == field3) && (!y3x3Features.occupied)) {
                            defaultFieldFeatures = y3x3Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y3x3Features = defaultFieldFeatures;
                        } else if ((v == field4) && (!y2x1Features.occupied)) {
                            defaultFieldFeatures = y2x1Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y2x1Features = defaultFieldFeatures;
                        } else if ((v == field5) && (!y2x2Features.occupied)) {
                            defaultFieldFeatures = y2x2Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y2x2Features = defaultFieldFeatures;
                        } else if ((v == field6) && (!y2x3Features.occupied)) {
                            defaultFieldFeatures = y2x3Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y2x3Features = defaultFieldFeatures;
                        } else if ((v == field7) && (!y1x1Features.occupied)) {
                            defaultFieldFeatures = y1x1Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y1x1Features = defaultFieldFeatures;
                        } else if ((v == field8) && (!y1x2Features.occupied)) {
                            defaultFieldFeatures = y1x2Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y1x2Features = defaultFieldFeatures;
                        } else if ((v == field9) && (!y1x3Features.occupied)) {
                            defaultFieldFeatures = y1x3Features;
                            defaultFieldFeatures.occupied = true;
                            if (view == object1) {
                                defaultObjectFeatures = bbbbFeatures;
                                defaultFieldFeatures.image = object1;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbFeatures = defaultObjectFeatures;

                            } else if (view == object2) {
                                defaultObjectFeatures = bbbbx2Features;
                                defaultFieldFeatures.image = object2;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                bbbbx2Features = defaultObjectFeatures;
                            } else if (view == object3) {
                                defaultObjectFeatures = rbrbFeatures;
                                defaultFieldFeatures.image = object3;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rbrbFeatures = defaultObjectFeatures;
                            } else if (view == object4) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object4;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrFeatures = defaultObjectFeatures;
                            } else if (view == object5) {
                                defaultObjectFeatures = rrbrFeatures;
                                defaultFieldFeatures.image = object5;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrbrx2Features = defaultObjectFeatures;
                            } else if (view == object6) {
                                defaultObjectFeatures = brrrFeatures;
                                defaultFieldFeatures.image = object6;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrFeatures = defaultObjectFeatures;
                            } else if (view == object7) {
                                defaultObjectFeatures = brrrx2Features;
                                defaultFieldFeatures.image = object7;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                brrrx2Features = defaultObjectFeatures;
                            } else if (view == object8) {
                                defaultObjectFeatures = rrrrFeatures;
                                defaultFieldFeatures.image = object8;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrFeatures = defaultObjectFeatures;
                            } else if (view == object9) {
                                defaultObjectFeatures = rrrrx2Features;
                                defaultFieldFeatures.image = object9;
                                defaultFieldFeatures.colorTop = defaultObjectFeatures.colorTop;
                                defaultFieldFeatures.colorBottom = defaultObjectFeatures.colorBottom;
                                defaultFieldFeatures.colorLeft = defaultObjectFeatures.colorLeft;
                                defaultFieldFeatures.colorRight = defaultObjectFeatures.colorRight;
                                defaultObjectFeatures.used = true;
                                defaultObjectFeatures.positionY = defaultFieldFeatures.positionY;
                                defaultObjectFeatures.positionX = defaultFieldFeatures.positionX;
                                rrrrx2Features = defaultObjectFeatures;
                            }
                            y1x3Features = defaultFieldFeatures;
                        }
                        objects.remove(prevoriousObject);
                        if (objects.size() > 1) {
                            if (objects.get(objects.indexOf(currentObject)) == (objects.get(objects.size() - 1))) {
                                prevoriousObject = currentObject;
                                currentObject = objects.get(0);
                                prevoriousObject.setVisibility(View.VISIBLE);
                            } else {
                                prevoriousObject = objects.get(objects.indexOf(currentObject));
                                currentObject = objects.get(objects.indexOf(currentObject) + 1);
                                prevoriousObject.setVisibility(View.VISIBLE);
                            }
                        } else if (objects.size() == 1) {
                            prevoriousObject = objects.get(0);
                            currentObject = null;
                            prevoriousObject.setVisibility(View.VISIBLE);
                        } else if (objects.isEmpty()) {
                            prevoriousObject = null;
                            currentObject = null;
                        }
                    }
                    else {
                        v = currentStick;

                        viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);
                        containView = currentStick;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);
                    }


                    if (bbbbFeatures.used) {
                        object1.setOnTouchListener(null);
                        object1.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (bbbbx2Features.used) {
                        object2.setOnTouchListener(null);
                        object2.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (rbrbFeatures.used) {
                        object3.setOnTouchListener(null);
                        object3.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (rrbrFeatures.used) {
                        object4.setOnTouchListener(null);
                        object4.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (rrbrx2Features.used) {
                        object5.setOnTouchListener(null);
                        object5.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (brrrFeatures.used) {
                        object6.setOnTouchListener(null);
                        object6.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (brrrx2Features.used) {
                        object7.setOnTouchListener(null);
                        object7.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (rrrrFeatures.used) {
                        object8.setOnTouchListener(null);
                        object8.setBackgroundResource(R.drawable.grayfill);
                    }
                    if (rrrrx2Features.used) {
                        object9.setOnTouchListener(null);
                        object9.setBackgroundResource(R.drawable.grayfill);
                    }


                    if (objects.isEmpty()) {
                        if (y3x1Features.occupied && y3x2Features.occupied) {
                            if (y3x1Features.colorRight.equals(y3x2Features.colorLeft)) {
                                hTest1 = true;
                            }
                        }
                    }
                    if (hTest1) {
                        if (y3x2Features.occupied && y3x3Features.occupied) {
                            if (y3x2Features.colorRight.equals(y3x3Features.colorLeft)) {
                                hTest2 = true;
                            }
                        }
                    }
                    if (hTest2) {
                        if (y2x1Features.occupied && y2x2Features.occupied) {
                            if (y2x1Features.colorRight.equals(y2x2Features.colorLeft)) {
                                hTest3 = true;
                            }
                        }
                    }
                    if (hTest3) {
                        if (y2x2Features.occupied && y2x3Features.occupied) {
                            if (y2x2Features.colorRight.equals(y2x3Features.colorLeft)) {
                                hTest4 = true;
                            }
                        }
                    }
                    if (hTest4) {
                        if (y1x1Features.occupied && y1x2Features.occupied) {
                            if (y1x1Features.colorRight.equals(y1x2Features.colorLeft)) {
                                hTest5 = true;
                            }
                        }
                    }
                    if (hTest5) {
                        if (y1x2Features.occupied && y1x3Features.occupied) {
                            if (y1x2Features.colorRight.equals(y1x3Features.colorLeft)) {
                                hTest6 = true;
                            }
                        }
                    }
                    if (hTest6) {
                        if (y3x1Features.occupied && y2x1Features.occupied) {
                            if (y3x1Features.colorBottom.equals(y2x1Features.colorTop)) {
                                vTest1 = true;
                            }
                        }
                    }
                    if (vTest1) {
                        if (y3x2Features.occupied && y2x2Features.occupied) {
                            if (y3x2Features.colorBottom.equals(y2x2Features.colorTop)) {
                                vTest2 = true;
                            }
                        }
                    }
                    if (vTest2) {
                        if (y3x3Features.occupied && y2x3Features.occupied) {
                            if (y3x3Features.colorBottom.equals(y2x3Features.colorTop)) {
                                vTest3 = true;
                            }
                        }
                    }
                    if (vTest3) {
                        if (y2x1Features.occupied && y1x1Features.occupied) {
                            if (y2x1Features.colorBottom.equals(y1x1Features.colorTop)) {
                                vTest4 = true;
                            }
                        }
                    }
                    if (vTest4) {
                        if (y2x2Features.occupied && y1x2Features.occupied) {
                            if (y2x2Features.colorBottom.equals(y1x2Features.colorTop)) {
                                vTest5 = true;
                            }
                        }
                    }
                    if (vTest5) {
                        if (y2x3Features.occupied && y1x3Features.occupied) {
                            if (y2x3Features.colorBottom.equals(y1x3Features.colorTop)) {
                                vTest6 = true;
                            }
                        }
                    }
                    if (vTest6) {
                        MAINTEST = true;
                    }
                    if (objects.isEmpty()) {
                        if (MAINTEST) activity.setBackgroundColor(R.drawable.greenfill);
                        else activity.setBackgroundColor(R.drawable.redfill);
                    }
                    break;
                //the drag and drop operation has concluded.
                case DragEvent.ACTION_DRAG_ENDED:
                    //go back to normal shape
                    v.setBackgroundResource(R.drawable.graybackground);


                default:
                    break;
            }
            return true;

        }

    }


    private static class ObjectFeatures {

        private ImageView imageView;
        private boolean used;
        private float positionX, positionY;
        private String colorTop, colorBottom, colorLeft, colorRight;

        ObjectFeatures(ImageView imageView, boolean used, float positionY, float positionX,
                       String colorTop, String colorBottom, String colorLeft, String colorRight) {
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

    private static class FieldFeatures {
        private RelativeLayout field;
        private ImageView image;
        float positionX, positionY;
        String colorTop, colorBottom, colorLeft, colorRight;
        private boolean occupied;

        FieldFeatures(RelativeLayout field, ImageView image, boolean occupied,
                      float positionY, float positionX,
                      String colorTop, String colorBottom, String colorLeft, String colorRight) {
            this.field = field;
            this.image = image;
            this.occupied = occupied;
            this.positionY = positionY;
            this.positionX = positionX;
            this.colorTop = colorTop;
            this.colorBottom = colorBottom;
            this.colorLeft = colorLeft;
            this.colorRight = colorRight;
        }

    }
}