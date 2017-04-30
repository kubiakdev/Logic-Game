package com.example.robert.smilesad;

/**
 * Created by Robert on 2017-04-21.
 */

public class TestLevel {

    boolean hTest1 = false;    // Test horizontal y1x1 - y1x2
    boolean hTest2 = false;    // Test horizontal y1x2 - y1z3
    boolean hTest3 = false;    // Test horizontal y2x1 - y2x2
    boolean hTest4 = false;    // Test horizontal y2x2 - y2x3
    boolean hTest5 = false;    // Test horizontal y3x1 - y3x2
    boolean hTest6 = false;    // Test horizontal y3x2 - y3x3

    boolean vTest1 = false;    // Test vertical y1x1 - y2x1
    boolean vTest2 = false;    // Test vertical y1x2 - y2x2
    boolean vTest3 = false;    // Test vertical y1x3 - y2x3
    boolean vTest4 = false;    // Test vertical y2x1 - y3x1
    boolean vTest5 = false;    // Test vertical y2x2 - y3x2
    boolean vTest6 = false;    // Test vertical y2x2 - y3x3

    boolean[] results;


    TestLevel(FieldFeatures y1x1Features,
              FieldFeatures y1x2Features,
              FieldFeatures y1x3Features,
              FieldFeatures y2x1Features,
              FieldFeatures y2x2Features,
              FieldFeatures y2x3Features,
              FieldFeatures y3x1Features,
              FieldFeatures y3x2Features,
              FieldFeatures y3x3Features) {

        hTest1 = !y1x1Features.enabled || !y1x2Features.enabled || doHTest(y1x1Features, y1x2Features);
        hTest2 = !y1x2Features.enabled || !y1x3Features.enabled || doHTest(y1x2Features, y1x3Features);
        hTest3 = !y2x1Features.enabled || !y2x2Features.enabled || doHTest(y2x1Features, y2x2Features);
        hTest4 = !y2x2Features.enabled || !y2x3Features.enabled || doHTest(y2x2Features, y2x3Features);
        hTest5 = !y3x1Features.enabled || !y3x2Features.enabled || doHTest(y3x1Features, y3x2Features);
        hTest6 = !y3x2Features.enabled || !y3x3Features.enabled || doHTest(y3x2Features, y3x3Features);

        vTest1 = !y1x1Features.enabled || !y2x1Features.enabled || doVTest(y1x1Features, y2x1Features);
        vTest2 = !y1x2Features.enabled || !y2x2Features.enabled || doVTest(y1x2Features, y2x2Features);
        vTest3 = !y1x3Features.enabled || !y2x3Features.enabled || doVTest(y1x3Features, y2x3Features);
        vTest4 = !y2x1Features.enabled || !y3x1Features.enabled || doVTest(y2x1Features, y3x1Features);
        vTest5 = !y2x2Features.enabled || !y3x2Features.enabled || doVTest(y2x2Features, y3x2Features);
        vTest6 = !y2x3Features.enabled || !y3x3Features.enabled || doVTest(y2x3Features, y3x3Features);

        results = new boolean[]
                {hTest1, hTest2, hTest3, hTest4, hTest5, hTest6, vTest1, vTest2, vTest3, vTest4, vTest5, vTest6};
        Board.MAINTEST = testAll(results);
        if (Board.MAINTEST) Board.activity.setBackgroundResource(R.color.green);
        else Board.activity.setBackgroundResource(R.color.red);

    }

    public boolean doHTest(FieldFeatures field1, FieldFeatures field2) {
        if (field1.colorRight.equals(field2.colorLeft)) {
            return true;
        }
        return false;
    }

    public boolean doVTest(FieldFeatures field1, FieldFeatures field2) {
        if (field1.colorTop == field2.colorBottom)
            return true;
        return false;
    }

    public boolean testAll(boolean[] results) {
        for (int i = 0; i < results.length; i++) {
            if (!results[i]) return false;
        }
        return true;
    }
}
