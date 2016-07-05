package com.mac.training.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mTxt;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences shP = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = shP.edit();
        edit.putString("myKey", mTxt.getText().toString());
        edit.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxt = (EditText) findViewById(R.id.myText);

        SharedPreferences shP = getPreferences(MODE_PRIVATE);

        String tmpStr;
        tmpStr = shP.getString("myKey","Placeholder");

        mTxt.setText(tmpStr);

    }
}
