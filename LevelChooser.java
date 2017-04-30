package com.example.robert.smilesad;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;


/**
 * Created by Robert on 2017-04-15.
 */

public class LevelChooser extends Activity {

    static HashMap<RelativeLayout,FieldFeatures> fieldMap = new HashMap<>();
    static HashMap<ImageView, ObjectFeatures> objectMap = new HashMap<>();

    public static void whatLevel(int i){
        if(i==1) setLevel1();
        if(i==2) setLevel2();
    }


    static void setLevel1(){

       Board.object1 = Board.bbbb;
        Board.object2 = Board.bbbbx2;
        Board.object3 = Board.bbbbx3;
        Board.object4 = Board.brbr;
        Board.object5 = Board.brbrx2;

        Board.objects.add(Board.object1);
        Board.objects.add(Board.object2);
        Board.objects.add(Board.object3);
        Board.objects.add(Board.object4);
        Board.objects.add(Board.object5);

        objectMap.put(Board.object1, GetFeatures.bbbbFeatures);
        objectMap.put(Board.object2, GetFeatures.bbbbx2Features);
        objectMap.put(Board.object3, GetFeatures.bbbbx3Features);
        objectMap.put(Board.object4, GetFeatures.brbrFeatures);
        objectMap.put(Board.object5, GetFeatures.brbrx2Features);

        Board.field1 = Board.y3x2;
        Board.field2 = Board.y2x1;
        Board.field3 = Board.y2x2;
        Board.field4 = Board.y2x3;
        Board.field5 = Board.y1x2;

        fieldMap.put(Board.field1, GetFeatures.y3x2Features);
        fieldMap.put(Board.field2, GetFeatures.y2x1Features);
        fieldMap.put(Board.field3, GetFeatures.y2x2Features);
        fieldMap.put(Board.field4, GetFeatures.y2x3Features);
        fieldMap.put(Board.field5, GetFeatures.y1x2Features);

        Board.y3x3.setBackgroundResource(R.drawable.graybackgroundfaded);
        Board.y3x1.setBackgroundResource(R.drawable.graybackgroundfaded);
        Board.y1x3.setBackgroundResource(R.drawable.graybackgroundfaded);
        Board.y1x1.setBackgroundResource(R.drawable.graybackgroundfaded);

        GetFeatures.y3x3Features.enabled=false;
        GetFeatures.y3x1Features.enabled=false;
        GetFeatures.y1x3Features.enabled=false;
        GetFeatures.y1x1Features.enabled=false;

    }

    public static void setLevel2(){}
}
