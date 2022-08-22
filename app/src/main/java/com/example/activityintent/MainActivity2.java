package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.android.MainActivity2.extra.REPLY";
    private EditText mReply;

    //Log
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent =getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

    }

    public void ReturnReply(View view){
        mReply = findViewById(R.id.editText_second);
        String reply = mReply.getText().toString();
        Intent replyintent = new Intent();
        replyintent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, replyintent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();

    }
}