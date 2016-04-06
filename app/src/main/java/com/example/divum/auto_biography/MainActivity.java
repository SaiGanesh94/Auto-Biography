package com.example.divum.auto_biography;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.divum.users_home_page.UsersHomePage;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextInputLayout username;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    TextInputLayout password;
    private SliderLayout sliderLayout;
    Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        sliderLayout=(SliderLayout)findViewById(R.id.slider);
        Toolbar toolBar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);

        loginButton = (LoginButton)findViewById(R.id.login_button);
        username=(TextInputLayout)findViewById(R.id.view);
        password=(TextInputLayout)findViewById(R.id.password_view);

        HashMap<String,Integer> file_maps=new HashMap<String,Integer>();
        file_maps.put("Shankar", R.drawable.shankar_vijay);
        file_maps.put("Cinema Stars", R.drawable.cinema2);
        file_maps.put("mani_rathnam", R.drawable.mani_rathnam);
        file_maps.put("Epic Pic", R.drawable.rmb);
        file_maps.put("Kathithi Shooting Spot", R.drawable.vijaymuragadoss);

        for(String name:file_maps.keySet()){
            TextSliderView textSliderView=new TextSliderView(this);
            textSliderView.description(name).image(file_maps.get(name)).setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent=new Intent(MainActivity.this,UsersHomePage.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        });

        Button btn=(Button)findViewById(R.id.sign_in);
        btnRegistration=(Button)findViewById(R.id.registration);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });


        btn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            submitForm();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });
    }

    private void submitForm() {
        if(!isValidateEmail()){
            return;
        }

        if(!isValidatePassword()){
            return;
        }

        Intent intent=new Intent(this, UsersHomePage.class);
        intent.putExtra("Name", username.getEditText().getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private boolean isValidateEmail() {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        if(username.getEditText().getText().toString().isEmpty()
                || (!sharedPreferences.getString("email_id",username.getEditText().getText().toString()).equals(username.getEditText().getText().toString()))){
            username.setError("Enter your mail-id correctly");
            return false;
        } else{
            username.setErrorEnabled(false);
        }
        return true;
    }

    private boolean isValidatePassword(){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        if(password.getEditText().getText().toString().isEmpty()||
                (!sharedPreferences.getString(username.getEditText().getText().toString(),password.getEditText().getText().toString()).equals(password.getEditText().getText().toString()))){
            password.setError("Enter your password correctly");
            password.setErrorEnabled(true);
            return false;
        }else {
            password.setErrorEnabled(false);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
