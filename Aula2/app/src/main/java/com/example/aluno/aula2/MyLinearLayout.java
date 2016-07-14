package com.example.aluno.aula2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Aluno on 13/07/2016.
 */
public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOrientation(VERTICAL);

        TextView text = new TextView(context);
        text.setText(R.string.app_name);

        addView(text);
    }
}
