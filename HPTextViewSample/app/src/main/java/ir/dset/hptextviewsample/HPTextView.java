package ir.dset.hptextviewsample;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

public class HPTextView extends TextView {

    public HPTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public HPTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HPTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attributeSet, int defStyle) {
        final TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.HPTextView, defStyle, 0);
        amazingCharColor = typedArray.getColor(R.styleable.HPTextView_amazingcolor, amazingCharColor);
        fontName = typedArray.getString(R.styleable.HPTextView_font);
        typedArray.recycle();

        boolean[] buffer = new boolean[this.getText().length()];
        for (int i = 0; i < this.getText().length(); i++) {
            if (this.getText().charAt(i) == 1611 ||
                    this.getText().charAt(i) == 1612 ||
                    this.getText().charAt(i) == 1613 ||
                    this.getText().charAt(i) == 1614 ||
                    this.getText().charAt(i) == 1615 ||
                    this.getText().charAt(i) == 1616 ||
                    this.getText().charAt(i) == 1617 ||
                    this.getText().charAt(i) == 1618 ||
                    this.getText().charAt(i) == 1619
                    ) {
                buffer[i] = true;
            }
        }
        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(this.getText());

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == true)
                spannableString.setSpan(new ForegroundColorSpan(amazingCharColor), i, i + 1, 0);
        }
        builder.append(spannableString);
        this.setText(builder, BufferType.SPANNABLE);

        if (fontName != null) {
            Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), fontName);
            setTypeface(typeFace);
        }
    }


    public int getAmazingCharColor() {
        return amazingCharColor;
    }

    public void setAmazingCharColor(int amazingCharColor) {
        this.amazingCharColor = amazingCharColor;
    }

    public String getFontName() {
        return fontName;
    }
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    private int amazingCharColor = Color.RED;
    private String fontName = null;
}