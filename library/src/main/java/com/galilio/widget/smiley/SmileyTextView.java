package com.galilio.widget.smiley;

import android.widget.TextView;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class SmileyTextView extends TextView {
    SmileyFactory mSmileyFactory = null;
    
    public SmileyTextView(Context context) {
        this(context, null);
    }
    
    public SmileyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public SmileyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ensureSmileyFactory();
        
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SmileyTextView);
        
        String value = a.getString(R.styleable.SmileyTextView_text);
        if (value != null) {
            setText(value, BufferType.SPANNABLE);
        }
        
        a.recycle();
    }
    
    private void ensureSmileyFactory() {
        synchronized(this) {
            if (mSmileyFactory == null) {
                mSmileyFactory = new SmileyFactory(getContext());
                
                setSpannableFactory(mSmileyFactory);
            }
        }
    }
}
