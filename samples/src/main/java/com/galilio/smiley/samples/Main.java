package com.galilio.widget.smiley.samples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.galilio.widget.smiley.SmileyFactory;

public class Main extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tx = (TextView)findViewById(R.id.s1);
        SmileyFactory factory = new SmileyFactory(this);
        tx.setSpannableFactory(factory);
        
        tx.setText("hello [smiley_heart], welcome [smiley_like]", TextView.BufferType.SPANNABLE);
    }
}
