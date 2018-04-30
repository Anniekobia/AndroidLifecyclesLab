package com.example.android.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText reply;
    public static final String LOG_TAG=SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i=getIntent();
        String msg=i.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView t= findViewById(R.id.text_message);
        t.setText(msg);

        reply=findViewById(R.id.editText_second);

        Log.d(LOG_TAG,"onCreate");

    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    public void returnReply(View view) {
        String r=reply.getText().toString();

        Intent t=new Intent();
        t.putExtra(EXTRA_REPLY,r);
        setResult(RESULT_OK,t);
        finish();
        Log.d(LOG_TAG,"End of SecondActivity");

    }
    public static final  String EXTRA_REPLY="com.example.android.twoactivities.extra.REPLY";
}
