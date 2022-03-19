package com.androidpprog2.crimenes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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
        editText.getText();
        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
