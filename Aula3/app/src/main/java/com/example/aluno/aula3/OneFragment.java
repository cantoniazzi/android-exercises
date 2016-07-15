package com.example.aluno.aula3;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Aluno on 14/07/2016.
 */
public class OneFragment extends Fragment {
    private EditText mEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEditText = (EditText) getView().findViewById(R.id.editText);

        getView().findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftButtonClick(view);
            }
        });

        getView().findViewById(R.id.btn_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightButtonClick(view);
            }
        });
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
        return getActivity().getSharedPreferences("com.example.aluno.aula3", Context.MODE_PRIVATE);
    }
}
