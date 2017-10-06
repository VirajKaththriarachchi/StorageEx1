package com.industrialmaster.storageex;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences profile = null;
    EditText etName;
    EditText etMobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = getPreferences(MODE_PRIVATE);
        etName = (EditText) findViewById(R.id.editText);
        etMobile = (EditText) findViewById(R.id.editText2);
        String name = profile.getString("name", "-");
        String mobile = profile.getString("mobile", "-");
        etName.setText(name);
        etMobile.setText(mobile);
    }


    public void save(View v){

        String name = etName.getText().toString();
        String mobile = etMobile.getText().toString();

        SharedPreferences.Editor profileEditor = profile.edit();
        profileEditor.putString("name",name);
        profileEditor.putString("mobile",mobile);
        profileEditor.commit();


    }
}
