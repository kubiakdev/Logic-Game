package com.example.robert.smilesad;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Robert on 2017-04-16.
 */

public class BasicCreateSettings {

    public static ImageView [] objectsBoard = new ImageView[9];
    public static RelativeLayout[] fieldBoard = new RelativeLayout[9];

    public static void setBasic3x3() {
        Board.objectsStartCounter = Board.objects.size();

        objectsBoard[0] = Board.object1;
        objectsBoard[1] = Board.object2;
        objectsBoard[2] = Board.object3;
        objectsBoard[3] = Board.object4;
        objectsBoard[4] = Board.object5;
        objectsBoard[5] = Board.object6;
        objectsBoard[6] = Board.object7;
        objectsBoard[7] = Board.object8;
        objectsBoard[8] = Board.object9;

        fieldBoard[0] = Board.field1;
        fieldBoard[1] = Board.field2;
        fieldBoard[2] = Board.field3;
        fieldBoard[3] = Board.field4;
        fieldBoard[4] = Board.field5;
        fieldBoard[5] = Board.field6;
        fieldBoard[6] = Board.field7;
        fieldBoard[7] = Board.field8;
        fieldBoard[8] = Board.field9;


        for (int i = 0; i < Board.objectsStartCounter; i++){
            objectsBoard[i].setTag(Board.IMAGEVIEW_TAG);
            objectsBoard[i].setOnTouchListener(new MyTouchListener());
            fieldBoard[i].setOnDragListener(new MyDragListener());
        }
    }
}
