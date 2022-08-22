package com.example.activityintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.MainActivity.extra.message";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    private TextView mReplyTextView;


    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode==TEXT_REQUEST){
        if(resultCode == RESULT_OK){

            String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
            mReplyTextView.setText(reply);
            mReplyTextView.setText(reply);
            mReplyHeadTextView.setVisibility(View.VISIBLE);
            mReplyTextView.setVisibility(View.VISIBLE);

        }
    }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


        mMessageEditText=findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);



    }

    public void launchSecondActivity(View view){
        Log.d(LOG_TAG,"Button Clicked!");
        Intent intent= new Intent(this,MainActivity2.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        Log.d(LOG_TAG,"Button Clicked!");
        startActivityForResult(intent, TEXT_REQUEST);
    }
}