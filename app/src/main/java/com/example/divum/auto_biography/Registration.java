package com.example.divum.auto_biography;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends ActionBarActivity {

    EditText mEmail_id;
    EditText mPassword;
    EditText mConfirmPassword;
    Button mBtnSubmit;
    Button mBtnCancel;

    public static final String EMAIL="email_id";
    public static final String PASSWORD="password";
    public static final String MY_PREFERENCES="MyPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toolbar toolBar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Regisration");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mEmail_id=(EditText)findViewById(R.id.email_id);
        mPassword=(EditText)findViewById(R.id.password);
        mConfirmPassword=(EditText)findViewById(R.id.confirm_password);

        mBtnSubmit=(Button)findViewById(R.id.submit);
        mBtnCancel=(Button)findViewById(R.id.cancel);

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkregistration();
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Registration.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void Checkregistration(){
        if(!vaildPassword()){
            return;
        }
        if(!getFromSharedPreference()){
            return;
        }
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean getFromSharedPreference(){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getString(EMAIL,mEmail_id.getText().toString()).isEmpty()
                && sharedPreferences.getString(PASSWORD,mPassword.getText().toString()).isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean vaildPassword(){
         if(mPassword.getText().toString().equals("") && mConfirmPassword.getText().toString().equals("")){
            mPassword.setError("Enter Password Correctly");
            mConfirmPassword.setError("Enter Confirm Password Correctly ");
            return false;
        }
         if (mPassword.getText().toString().equals("")) {
            mPassword.setError("Enter Password Correctly");
            return false;
        }
        if(mConfirmPassword.getText().toString().equals("")){
            mConfirmPassword.setError("Enter Confirm Password Correctly");
            return false;
        }
        else if(!mConfirmPassword.getText().toString().equals(mPassword.getText().toString())){
                 mPassword.setError("Enter Password Correctly");
                 mConfirmPassword.setError("Enter Confirm Password Correctly");
                 return false;
        }
        SharedPreferences sharedPreferences=getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(EMAIL,mEmail_id.getText().toString());
        editor.putString(mEmail_id.getText().toString(),mPassword.getText().toString());
        editor.commit();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       if(id==R.id.home){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
