package com.example.robert.smilesad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class Board extends Activity {

    static ImageView object1;
    static ImageView object2;
    static ImageView object3;
    static ImageView object4;
    static ImageView object5;
    static ImageView object6;
    static ImageView object7;
    static ImageView object8;
    static ImageView object9;


    static ImageView bbbb, bbbbx2, bbbbx3;
    static ImageView bbbr;
    static ImageView bbrb;
    static ImageView brbb;
    static ImageView rbbb;
    static ImageView rrbb;
    static ImageView brrb;
    static ImageView bbrr;
    static ImageView rbbr;
    static ImageView brrr, brrrx2;
    static ImageView rbrr;
    static ImageView rrbr, rrbrx2;
    static ImageView rrrb;
    static ImageView rrrr;
    static ImageView rbrb;
    static ImageView brbr, brbrx2;

    static RelativeLayout currentStick;
    static RelativeLayout activity;
    static RelativeLayout field1;
    static RelativeLayout field2;
    static RelativeLayout field3;
    static RelativeLayout field4;
    static RelativeLayout field5;
    static RelativeLayout field6;
    static RelativeLayout field7;
    static RelativeLayout field8;
    static RelativeLayout field9;


    static RelativeLayout y1x1;
    static RelativeLayout y1x2;
    static RelativeLayout y1x3;
    static RelativeLayout y2x1;
    static RelativeLayout y2x2;
    static RelativeLayout y2x3;
    static RelativeLayout y3x1;
    static RelativeLayout y3x2;
    static RelativeLayout y3x3;


    static ImageView previousObject;
    static ImageView currentObject;
    static ImageView nextlevelbutton;
    static ImageView replaylevelbutton;
    static final String IMAGEVIEW_TAG = "Sticks";
    static RelativeLayout leftButton, rightButton;
    static ArrayList<ImageView> objects = new ArrayList<>();
    static boolean MAINTEST = false;
    static int objectsStartCounter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        createAllObjects();
        GetFeatures.getObjectFeatures();
        GetFeatures.getFieldFeatures3x3();
        createFields3x3();
        LevelChooser.whatLevel(MainMenu.LEVEL);
        BasicCreateSettings.setBasic3x3();

        currentStick = (RelativeLayout) findViewById(R.id.currentsticks);
        currentStick.setOnDragListener(new MyDragListener());
        activity = (RelativeLayout) findViewById(R.id.activity_level1);
        nextlevelbutton = (ImageView) findViewById(R.id.nextlevelbutton);
        replaylevelbutton = (ImageView) findViewById(R.id.replaylevelbutton);

        previousObject = objects.get(0);
        object1.setVisibility(View.VISIBLE);
        currentObject = objects.get(0);

        leftButton = (RelativeLayout) findViewById(R.id.nextsticksleft);
        onPreviousStickButtonClick();
        rightButton = (RelativeLayout) findViewById(R.id.nextsticksright);
        onNextStickButtonClick();
        onNextLevelButtonClick();
    }

    public void createAllObjects() {
        bbbb = (ImageView) findViewById(R.id.bbbb);
        bbbbx2 = (ImageView) findViewById(R.id.bbbbx2);
        bbbbx3 = (ImageView) findViewById(R.id.bbbbx3);
        bbbr = (ImageView) findViewById(R.id.bbbr);
        bbrb = (ImageView) findViewById(R.id.bbrb);
        brbb = (ImageView) findViewById(R.id.brbb);
        rbbb = (ImageView) findViewById(R.id.rbbb);
        bbrr = (ImageView) findViewById(R.id.bbrr);
        brrb = (ImageView) findViewById(R.id.brrb);
        rrbb = (ImageView) findViewById(R.id.rrbb);
        rbbr = (ImageView) findViewById(R.id.rbbr);
        brrr = (ImageView) findViewById(R.id.brrr);
        brrrx2 = (ImageView) findViewById(R.id.brrrx2);
        rbrr = (ImageView) findViewById(R.id.rbrr);
        rrbr = (ImageView) findViewById(R.id.rrbr);
        rrbrx2 = (ImageView) findViewById(R.id.rrbrx2);
        rrrb = (ImageView) findViewById(R.id.rrrb);
        rrrr = (ImageView) findViewById(R.id.rrrr);
        rbrb = (ImageView) findViewById(R.id.rbrb);
        brbr = (ImageView) findViewById(R.id.brbr);
        brbrx2 = (ImageView) findViewById(R.id.brbrx2);

    }

    public void createFields3x3() {

        y3x1 = (RelativeLayout) findViewById(R.id.l1_y3x1);
        y3x2 = (RelativeLayout) findViewById(R.id.l1_y3x2);
        y3x3 = (RelativeLayout) findViewById(R.id.l1_y3x3);
        y2x1 = (RelativeLayout) findViewById(R.id.l1_y2x1);
        y2x2 = (RelativeLayout) findViewById(R.id.l1_y2x2);
        y2x3 = (RelativeLayout) findViewById(R.id.l1_y2x3);
        y1x1 = (RelativeLayout) findViewById(R.id.l1_y1x1);
        y1x2 = (RelativeLayout) findViewById(R.id.l1_y1x2);
        y1x3 = (RelativeLayout) findViewById(R.id.l1_y1x3);

    }

    public void onPreviousStickButtonClick() {
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousObject.setVisibility(View.GONE);
                if (previousObject == objects.get(0)) {
                    currentObject = objects.get(objects.size() - 1);
                    currentObject.setVisibility(View.VISIBLE);
                } else {
                    currentObject = objects.get(objects.indexOf(previousObject) - 1);
                    currentObject.setVisibility(View.VISIBLE);
                }
                previousObject = currentObject;
            }
        });
    }

    public void onNextStickButtonClick() {
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousObject.setVisibility(View.GONE);
                if (previousObject == objects.get(objects.size() - 1)) {
                    currentObject = objects.get(0);
                    currentObject.setVisibility(View.VISIBLE);
                } else {
                    currentObject = objects.get(objects.indexOf(previousObject) + 1);
                    currentObject.setVisibility(View.VISIBLE);
                }
                previousObject = currentObject;
            }
        });
    }

    public void onNextLevelButtonClick() {
        nextlevelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object1.setVisibility(View.GONE);
                object2.setVisibility(View.GONE);
                object3.setVisibility(View.GONE);
                object4.setVisibility(View.GONE);
                object5.setVisibility(View.GONE);
                object6.setVisibility(View.GONE);
                object7.setVisibility(View.GONE);
                object8.setVisibility(View.GONE);
                object9.setVisibility(View.GONE);
                object1.invalidate();
                object2.invalidate();
                object3.invalidate();
                object4.invalidate();
                object5.invalidate();
                object6.invalidate();
                object7.invalidate();
                object8.invalidate();
                object9.invalidate();
                MAINTEST = false;
                finish();
                startActivity(getIntent());
            }
        });
    }

    public static void backToLastPosition(){
    }
}