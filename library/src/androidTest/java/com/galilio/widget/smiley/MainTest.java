package com.galilio.widget.smily;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.galilio.widget.smily.MainTest \
 * com.galilio.widget.smily.tests/android.test.InstrumentationTestRunner
 */
public class MainTest extends ActivityInstrumentationTestCase2<Main> {

    public MainTest() {
        super("com.galilio.widget.smily", Main.class);
    }

}
