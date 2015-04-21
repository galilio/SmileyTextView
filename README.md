SmileyTextView

--------------

## USAGE
### 1.

```
TextView tx = (TextView)findViewById(R.id.s1);
SmileyFactory factory = new SmileyFactory(this);
tx.setSpannableFactory(factory);
        
tx.setText("hello [smiley_heart], welcome [smiley_like]", TextView.BufferType.SPANNABLE);
```

### 2.

```
<com.galilio.widget.smiley.SmileyTextView android:id="@+id/s2"
    android:textSize="16sp"
    app:text="Here is your [smiley_message]"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```

## TODO

* Add more smiley.

