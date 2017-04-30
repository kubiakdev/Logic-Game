package com.example.robert.smilesad;

import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;

/**
 * Created by Robert on 2017-04-20.
 */

public class Operations {

    static RelativeLayout currentMemoryField, lastMemoryField;
    static ImageView currentMemoryObject, lastMemoryObject;
    View v, view;


    Operations(View v, View view) {
        this.v = v;
        this.view = view;

    }

    public static void backToLastPosition(ImageView objectToUndo,
                                          RelativeLayout draggedField,
                                          ViewGroup viewGroup,
                                          DragEvent event) {
        objectToUndo = (ImageView) event.getLocalState();
        viewGroup = (ViewGroup) objectToUndo.getParent();
        viewGroup.removeView(objectToUndo);
        draggedField.addView(objectToUndo);
        objectToUndo.setVisibility(View.VISIBLE);
    }

    public static boolean isThisObjectUsed(View view) {
        ImageView testedObject = (ImageView) view;
        ObjectFeatures testedObjectFeatures = LevelChooser.objectMap.get(testedObject);
        if (testedObjectFeatures.used)
            return true;
        else
            return false;
    }

    public static ObjectFeatures getTouchedObject(View view) {
        ImageView testedObject = (ImageView) view;
        ObjectFeatures touchedObjectFeatures = LevelChooser.objectMap.get(testedObject);
        return touchedObjectFeatures;
    }
    public static RelativeLayout getDraggedField( ObjectFeatures touchedObjectFeatures){
        FieldFeatures draggedFieldFeatures = MyDragListener.layoutOfObjectsOnTheBoard.get(touchedObjectFeatures);
        return (RelativeLayout) getKeyFromHashMap(LevelChooser.fieldMap, draggedFieldFeatures);
    }
    public static Object getKeyFromHashMap(HashMap map, FieldFeatures fieldFeatures){
        for( Object o  : map.keySet()){
            if(map.get(o).equals(fieldFeatures)){
                return o;
            }
        }
        return Board.currentStick;
    }

    public static void setUsedFieldToFalse(ObjectFeatures touchedObjectFeatures, RelativeLayout draggedField) {
        touchedObjectFeatures.used = false;
        FieldFeatures draggedFieldFeatures = LevelChooser.fieldMap.get(draggedField);
        draggedFieldFeatures.occupied=false;
        draggedFieldFeatures.colorTop=null;
        draggedFieldFeatures.colorBottom=null;
        draggedFieldFeatures.colorLeft=null;
        draggedFieldFeatures.colorRight=null;
    }

    public static boolean isItOccupied(View view) {
        if (view == Board.currentStick) return true;
        else {
            View searchView;
            RelativeLayout testField = null;
            for (int i = 0; i < Board.objectsStartCounter; i++) {
                searchView = BasicCreateSettings.fieldBoard[i];
                if (searchView == view) {
                    testField = (RelativeLayout) searchView;
                }
            }
            return LevelChooser.fieldMap.get(testField).occupied;

        }
    }

    public static void showNextObject() {
        if (Board.objects.size() > 1) {
            if (Board.previousObject == Board.objects.get(Board.objects.size() - 1)) {
                Board.currentObject = Board.objects.get(0);
                Board.currentObject.setVisibility(View.VISIBLE);
            } else {
                Board.currentObject = Board.objects.get(Board.objects.indexOf(Board.previousObject) + 1);
                Board.currentObject.setVisibility(View.VISIBLE);
            }
        } else {
            Board.previousObject = Board.objects.get(0);
            Board.previousObject.setVisibility(View.GONE);
        }
    }

    public static void showPreviousObject() {
        Board.currentObject.setVisibility(View.GONE);
        Board.previousObject.setVisibility(View.VISIBLE);
        Board.currentObject = Board.previousObject;
        if(Board.objects.indexOf(Board.currentObject)==0){
            Board.previousObject = Board.objects.get(Board.objects.size()-1);
        }
        else Board.previousObject = Board.objects.get(Board.objects.indexOf(Board.currentObject)-1);
    }
    public static boolean objectHasANewPosition(View v){
        RelativeLayout testField;
        for (int i = 0; i<Board.objectsStartCounter; i++){
            testField=BasicCreateSettings.fieldBoard[i];
            if(testField==v) return true;
        }
        return false;
    }
}
