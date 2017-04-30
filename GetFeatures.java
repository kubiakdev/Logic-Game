package com.example.robert.smilesad;

/**
 * Created by Robert on 2017-04-13.
 */

public class GetFeatures {


    static ObjectFeatures defaultObjectFeatures;
    static ObjectFeatures bbbbFeatures;
    static ObjectFeatures bbbbx2Features;
    static ObjectFeatures bbbbx3Features;
    static ObjectFeatures bbbrFeatures;
    static ObjectFeatures bbrbFeatures;
    static ObjectFeatures brbbFeatures;
    static ObjectFeatures rbbbFeatures;
    static ObjectFeatures rrbbFeatures;
    static ObjectFeatures brrbFeatures;
    static ObjectFeatures bbrrFeatures;
    static ObjectFeatures rbbrFeatures;
    static ObjectFeatures brrrFeatures;
    static ObjectFeatures brrrx2Features;
    static ObjectFeatures rbrrFeatures;
    static ObjectFeatures rrbrFeatures;
    static ObjectFeatures rrbrx2Features;
    static ObjectFeatures rrrbFeatures;
    static ObjectFeatures rrrrFeatures;
    static ObjectFeatures rbrbFeatures;
    static ObjectFeatures brbrFeatures;
    static ObjectFeatures brbrx2Features;


    static FieldFeatures defaultFieldFeatures;
    static FieldFeatures y1x1Features;
    static FieldFeatures y1x2Features;
    static FieldFeatures y1x3Features;
    static FieldFeatures y1x4Features;
    static FieldFeatures y1x5Features;
    static FieldFeatures y1x6Features;
    static FieldFeatures y1x7Features;
    static FieldFeatures y2x1Features;
    static FieldFeatures y2x2Features;
    static FieldFeatures y2x3Features;
    static FieldFeatures y2x4Features;
    static FieldFeatures y2x5Features;
    static FieldFeatures y2x6Features;
    static FieldFeatures y2x7Features;
    static FieldFeatures y3x1Features;
    static FieldFeatures y3x2Features;
    static FieldFeatures y3x3Features;
    static FieldFeatures y3x4Features;
    static FieldFeatures y3x5Features;
    static FieldFeatures y3x6Features;
    static FieldFeatures y3x7Features;
    static FieldFeatures y4x1Features;
    static FieldFeatures y4x2Features;
    static FieldFeatures y4x3Features;
    static FieldFeatures y4x4Features;
    static FieldFeatures y4x5Features;
    static FieldFeatures y4x6Features;
    static FieldFeatures y4x7Features;
    static FieldFeatures y5x1Features;
    static FieldFeatures y5x2Features;
    static FieldFeatures y5x3Features;
    static FieldFeatures y5x4Features;
    static FieldFeatures y5x5Features;
    static FieldFeatures y5x6Features;
    static FieldFeatures y5x7Features;
    static FieldFeatures y6x1Features;
    static FieldFeatures y6x2Features;
    static FieldFeatures y6x3Features;
    static FieldFeatures y6x4Features;
    static FieldFeatures y6x5Features;
    static FieldFeatures y6x6Features;
    static FieldFeatures y6x7Features;
    static FieldFeatures y7x1Features;
    static FieldFeatures y7x2Features;
    static FieldFeatures y7x3Features;
    static FieldFeatures y7x4Features;
    static FieldFeatures y7x5Features;
    static FieldFeatures y7x6Features;
    static FieldFeatures y7x7Features;


    public static void getObjectFeatures() {
        defaultObjectFeatures = new ObjectFeatures("defaultObject",null, false,
                0, 0, "no color", "no color", "no color", "no color");
        bbbbFeatures = new ObjectFeatures("bbbb",null, false,
                0, 0, "blue", "blue", "blue", "blue");
        bbbbx2Features = new ObjectFeatures("bbbbx2",null, false,
                0, 0, "blue", "blue", "blue", "blue");
        bbbbx3Features = new ObjectFeatures("bbbbx3",null, false,
                0, 0, "blue", "blue", "blue", "blue");
        bbbrFeatures = new ObjectFeatures("bbbr",null, false,
                0, 0, "blue", "blue", "blue", "red");
        bbrbFeatures = new ObjectFeatures("bbrb",null, false,
                0, 0, "blue", "blue", "red", "blue");
        brbbFeatures = new ObjectFeatures("brbb",null, false,
                0, 0, "blue", "red", "blue", "blue");
        rbbbFeatures = new ObjectFeatures("rbbb",null, false,
                0, 0, "red", "blue", "blue", "blue");
        rrbbFeatures = new ObjectFeatures("rrbb",null, false,
                0, 0, "red", "red", "blue", "blue");
        brrbFeatures = new ObjectFeatures("brrb",null, false,
                0, 0, "blue", "red", "red", "blue");
        bbrrFeatures = new ObjectFeatures("bbrr",null, false,
                0, 0, "blue", "blue", "red", "red");
        rbbrFeatures = new ObjectFeatures("rbbr",null, false,
                0, 0, "red", "blue", "blue", "red");
        brrrFeatures = new ObjectFeatures("brrr",null, false,
                0, 0, "blue", "red", "red", "red");
        brrrx2Features = new ObjectFeatures("brrrx2",null, false,
                0, 0, "blue", "red", "red", "red");
        rbrrFeatures = new ObjectFeatures("rbrr",null, false,
                0, 0, "red", "blue", "red", "red");
        rrbrFeatures = new ObjectFeatures("rrbr",null, false,
                0, 0, "red", "blue", "red", "red");
        rrbrx2Features = new ObjectFeatures("rrbrx2",null, false,
                0, 0, "red", "blue", "red", "red");
        rrrbFeatures = new ObjectFeatures("rrrb",null, false,
                0, 0, "red", "red", "red", "blue");
        rrrrFeatures = new ObjectFeatures("rrrr",null, false,
                0, 0, "red", "red", "red", "red");
        rbrbFeatures = new ObjectFeatures("rbrb",null, false,
                0, 0, "red", "blue", "red", "blue");
        brbrFeatures = new ObjectFeatures("brbr",null, false,
                0, 0, "blue", "blue", "red", "red");
        brbrx2Features = new ObjectFeatures("brbrx2",null, false,
                0, 0, "blue", "blue", "red", "red");
    }

    public static void getFieldFeatures3x3() {
        defaultFieldFeatures = new FieldFeatures("defaultField",null, null, false, true, 0, 0,
                null, null, null, null);
        y3x1Features = new FieldFeatures("y3x1",null, null, false, true,3, 1,
                null, null, null, null);
        y3x2Features = new FieldFeatures("y3x2",null, null, false, true,3, 2,
                null, null, null, null);
        y3x3Features = new FieldFeatures("y3x3",null, null, false,true, 3, 3,
                null, null, null, null);
        y2x1Features = new FieldFeatures("y2x1",null, null, false,true,2, 1,
                null, null, null, null);
        y2x2Features = new FieldFeatures("y2x2",null, null, false,true,2, 2,
                null, null, null, null);
        y2x3Features = new FieldFeatures("y2x3",null, null, false,true,2, 3,
                null, null, null, null);
        y1x1Features = new FieldFeatures("y1x1",null, null, false,true,1, 1,
                null, null, null, null);
        y1x2Features = new FieldFeatures("y1x2",null, null, false,true,1, 2,
                null, null, null, null);
        y1x3Features = new FieldFeatures("y1x3",null, null, false,true,1, 3,
                null, null, null, null);
    }
}
