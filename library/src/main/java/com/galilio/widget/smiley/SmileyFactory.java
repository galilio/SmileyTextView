package com.galilio.widget.smiley;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class SmileyFactory extends Spannable.Factory
{
    private static final Pattern SMILY_PATTERN = Pattern.compile("\\[([a-zA-Z][a-zA-Z0-9_]*)\\]");

    public static final int ALIGN_BOTTOM = DynamicDrawableSpan.ALIGN_BOTTOM;
    public static final int ALIGN_BASELINE = DynamicDrawableSpan.ALIGN_BASELINE;

    private Context mContext;
    private int mAlign;

    public SmileyFactory(Context ctx) {
        this(ctx, ALIGN_BOTTOM);
    }
    
    public SmileyFactory(Context ctx, int align) {
        mContext = ctx;
        mAlign = align;
    }
    
    private int getDrawableId(String name) {
        int id = mContext.getResources().getIdentifier(name, "drawable", mContext.getPackageName());
        if (id == 0) {
            id = mContext.getResources().getIdentifier(name, "drawable", "com.galilio.widget.smily");
        }
        
        return id;
    }

    @Override
    public Spannable newSpannable(CharSequence source) {
        Spannable retval = super.newSpannable(source);
        Matcher matcher = SMILY_PATTERN.matcher(source);
        
        while(matcher.find()) {
            String resName = matcher.group(1);
            int id = getDrawableId(resName);
            if (id == 0) { // resource not found.
                continue;
            }
            
            ImageSpan icon = new ImageSpan(mContext, id, mAlign);
            retval.setSpan(icon, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return retval;
    }
    
    
    
    
}
