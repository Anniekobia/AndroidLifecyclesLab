package com.example.android.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText msgSent;
    private static final String LOG_TAG=MainActivity.class.getSimpleName();

    private TextView replyHeadTextView;
    private TextView replyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgSent = findViewById(R.id.editText_main);

        replyHeadTextView=findViewById(R.id.text_header_reply);
        replyTextView=findViewById(R.id.text_message_reply);

        Log.d(LOG_TAG,"......");
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

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button Clicked");
        Intent sendClick=new Intent(this,SecondActivity.class);
        String msg = msgSent.getText().toString();
        sendClick.putExtra(EXTRA_MESSAGE,msg);
        startActivityForResult(sendClick,TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String e = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                replyHeadTextView.setVisibility(View.VISIBLE);
                replyTextView.setText(e);
                replyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public static final String EXTRA_MESSAGE="com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST=1;
}
