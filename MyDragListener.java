package com.example.robert.smilesad;

import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;

/**
 * Created by Robert on 2017-04-15.
 */

public class MyDragListener implements View.OnDragListener {


    ViewGroup viewGroup;
    RelativeLayout container;
    RelativeLayout droppedField;
    ImageView grabbedObject, droppedObject;
    ObjectFeatures grabbedObjectFeatures;
    FieldFeatures draggedFieldFeatures, droppedFieldFeatures;

    static HashMap<ObjectFeatures, FieldFeatures> layoutOfObjectsOnTheBoard = new HashMap<>();

    @Override
    public boolean onDrag(View v, DragEvent event) {

        // Handles each of the expected events
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                grabbedObject = (ImageView) event.getLocalState();
                grabbedObjectFeatures = MyTouchListener.touchedObject;
                draggedFieldFeatures = layoutOfObjectsOnTheBoard.get(grabbedObjectFeatures);
                Operations.showNextObject();
                //signal for the start of a drag and drop operation.
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                if (!Operations.isItOccupied(v)) v.setBackgroundResource(R.drawable.shape);
                else if (Operations.isItOccupied(v)) v.setBackgroundResource(R.drawable.badshape);
                //the drag point has entered the bounding box of the View
                break;
            case DragEvent.ACTION_DRAG_LOCATION:
                //show current position
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundResource(R.drawable.graybackground);
                //the user has moved the drag shadow outside the bounding box of the View
                break;
            case DragEvent.ACTION_DROP:
                droppedObject = (ImageView) event.getLocalState();
                viewGroup = (ViewGroup) droppedObject.getParent();
                viewGroup.removeView(droppedObject);
                droppedField = (RelativeLayout) v;
                droppedField.addView(droppedObject);
                droppedObject.setVisibility(View.VISIBLE);
                droppedFieldFeatures = LevelChooser.fieldMap.get(v);
                if (draggedFieldFeatures == droppedFieldFeatures) {
                    Operations.showPreviousObject();
                    break;
                } else if (Operations.objectHasANewPosition(v)) {
                    if (!Operations.isItOccupied(v)) {
                        new Inheritance(droppedObject, droppedField);
                        layoutOfObjectsOnTheBoard.put(grabbedObjectFeatures, droppedFieldFeatures);
                    } else{
                        Operations.backToLastPosition(droppedObject, MyTouchListener.draggedField, viewGroup, event);


                        droppedObject = (ImageView) event.getLocalState();
                        viewGroup = (ViewGroup) droppedObject.getParent();
                        viewGroup.removeView(droppedObject);
                        MyTouchListener.draggedField.addView(droppedObject);
                        droppedObject.setVisibility(View.VISIBLE);
                    }
                }
                Board.objects.remove(Board.previousObject);
                if (Board.objects.size() > 1) {
                    if (Board.objects.get(Board.objects.indexOf(Board.currentObject)) == (Board.objects.get(Board.objects.size() - 1))) {
                        Board.previousObject = Board.currentObject;
                        Board.currentObject = Board.objects.get(0);
                        Board.previousObject.setVisibility(View.VISIBLE);
                    } else {
                        Board.previousObject = Board.objects.get(Board.objects.indexOf(Board.currentObject));
                        Board.currentObject = Board.objects.get(Board.objects.indexOf(Board.currentObject) + 1);
                        Board.previousObject.setVisibility(View.VISIBLE);
                    }
                } else if (Board.objects.size() == 1) {
                    Board.previousObject = Board.objects.get(0);
                    Board.currentObject = null;
                    Board.previousObject.setVisibility(View.VISIBLE);
                } else if (Board.objects.isEmpty()) {
                    Board.previousObject = null;
                    Board.currentObject = null;
                } else {
                    v = Board.currentStick;

                    Operations.currentMemoryObject = (ImageView) event.getLocalState();
                    viewGroup = (ViewGroup) Operations.currentMemoryObject.getParent();
                    viewGroup.removeView(Operations.currentMemoryObject);
                    Operations.currentMemoryField = Board.currentStick;
                    Operations.currentMemoryField.addView(Operations.currentMemoryObject);
                    Operations.currentMemoryObject.setVisibility(View.VISIBLE);
                }
                Operations.lastMemoryField = (RelativeLayout) v;
                Operations.lastMemoryObject = (ImageView) event.getLocalState();
                if(Board.objects.size()==0) {
                    new TestLevel(GetFeatures.y1x1Features, GetFeatures.y1x2Features,
                            GetFeatures.y1x3Features, GetFeatures.y2x1Features,
                            GetFeatures.y2x2Features, GetFeatures.y2x3Features,
                            GetFeatures.y3x1Features, GetFeatures.y3x2Features,
                            GetFeatures.y3x3Features);
                }
                //drag shadow has been released,the drag point is within the bounding box of the View
                break;
            case DragEvent.ACTION_DRAG_ENDED:
            default:
                //the drag and drop operation has concluded.
                break;
        }
        return true;
    }
}