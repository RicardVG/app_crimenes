package com.androidpprog2.crimenes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class NewTask extends AppCompatActivity {

    public static Intent newIntent(Context packageContext, String title) {
        Intent intent = new Intent(packageContext, NewTask.class);
        intent.putExtra("title",title);
        return intent;
    }

    String Value;
    private TextView textEditTask;
    private Button saveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textEditTask = (TextView) findViewById(R.id.textEditTask);
        EditText editText = (EditText) findViewById(R.id.editText);
        saveTask = (Button) findViewById(R.id.saveTask);
        Handler handler = new Handler();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s,int start, int count, int after){
                //
            }
            @Override
            public void onTextChanged ( final CharSequence s, int start, int before, int count){
                //handler.removeCallbacks(input_finish_checker);
               // editText.setCompoundDrawables(null, null, editText.getText().toString().equals("") ? null : x, null);
                Value = editText.getText().toString();
                editText.setText(Value);
            }

            @Override
            public void afterTextChanged ( final Editable s){
             /*   if (s.length() > 0) {
                    last_text_edit = System.currentTimeMillis();
                    handler.postDelayed(input_finish_checker, delay);
                } else {

                }

              */
            }
        });
    }
}
