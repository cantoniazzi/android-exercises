package com.example.aluno.aula2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Aluno on 12/07/2016.
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private AlertDialog alert;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            Intent intent = new Intent(this,ListActivity.class);

            intent.putExtra("MY_KEY","Minha informaçao");
            intent.putExtra("MY_BOOL_KEY",true);

            startActivityForResult(intent,0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            String text = data.getStringExtra("KEY_RETURN");

            //cria dialog com toast
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Msg Example!");
            builder.setMessage(text);

            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(MainActivity.this, "negativo = " + arg1, Toast.LENGTH_SHORT).show();
                }
            });

            alert = builder.create();
            alert.show();

            //Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert event in log
        Log.d(TAG, "onCreate");

        Button btn = (Button) findViewById(R.id.btnLogin);
        btn.setOnClickListener(this);

//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view){
//                startActivity(new Intent(MainActivity.this, ListActivity.class));
//            }
//        });

    }

    //    public void goToNewActivity(View view){
    //        Intent intent = new Intent(this,ListActivity.class);
    //        startActivity(intent);
    //    }

    @Override
    protected void onStart(){
        super.onStart();

        //insert event in log
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();

        //insert event in log
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();

        //insert event in log
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();

        //insert event in log
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        //insert event in log
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        //insert event in log
        Log.d(TAG, "onRestart");
    }
}
