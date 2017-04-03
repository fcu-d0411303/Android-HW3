package com.example.user.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * Created by User on 2017/4/2.
 */

public class HelloActivity extends ActionBarActivity {

    Button backbtn;
    EditText input;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);

        input = (EditText)findViewById(R.id.editText);
        backbtn = (Button)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(setName);

    }

    private OnClickListener setName = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String input_str = input.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("KEY_NAME", input_str);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}
