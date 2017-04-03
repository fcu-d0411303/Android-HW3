package com.example.user.myapplication2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        submit = (Button)findViewById(R.id.button);
        submit.setOnClickListener(gethoroscope);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private static final int ACTIVITY_SET_NAME =1;

    private OnClickListener gethoroscope = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,
                    HelloActivity.class);
            startActivityForResult(intent,ACTIVITY_SET_NAME);
        }

    };

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent) {

        String strName;

        if(intent == null)
            return;

        super.onActivityResult(requestCode, resultCode, intent);
        switch(requestCode) {
            case ACTIVITY_SET_NAME:
                strName = intent.getStringExtra("KEY_NAME");
                Toast.makeText(MainActivity.this,
                        "Hello "+strName.toString(),
                        Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case R.id.action_Web:
                Uri uri = Uri.parse("hppt://www.google.com.tw");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
