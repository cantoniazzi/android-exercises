package com.example.aluno.aula3;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Aluno on 14/07/2016.
 */
public class MainActivity extends Activity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
    }

    public void leftButtonClick(View view){
        SharedPreferences pfs = getPreferences();
        String text = pfs.getString("MY_KEY",null);

        mEditText.setText(text);
    }

    public void rightButtonClick(View view){
        SharedPreferences pfs = getPreferences();
        SharedPreferences.Editor editor = pfs.edit();

        editor.putString("MY_KEY", mEditText.getText().toString());
        editor.apply();
    }

    private SharedPreferences getPreferences(){
        return getSharedPreferences("com.example.aluno.aula3", Context.MODE_PRIVATE);
    }

}
