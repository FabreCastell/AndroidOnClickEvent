package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// TODO: XML onClick attribute & View id
public class Option1Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        bindView();
    }

    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_1);
        tvOutput = (TextView) findViewById(R.id.tv_body_1);
    }

    // This "process" method MUST be bound in the layout XML file, "android:onClick="process""
    public void process(View v) {
        if(v.getId() == R.id.btn_process_1) {
            greet();
        }if (v.getId() == R.id.act0N){
            nextPage();
        }if (v.getId() == R.id.act0B){
            backPage();
        }
        hideKeyboardInput(v);
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    private void nextPage(){
        Intent next = new Intent(this,Option2Activity.class);
        startActivity(next);
    }

    private void backPage(){
        Intent back = new Intent(this,Option0Activity.class);
        startActivity(back);
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
