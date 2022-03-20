package com.androidpprog2.crimenes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.UUID;

public class NewTask extends AppCompatActivity {

    public static Intent newIntent(Context packageContext, String uuid) {
        Intent intent = new Intent(packageContext, NewTask.class);
        intent.putExtra("uuid",uuid);
        return intent;
    }

    private TextView textEditTask;
    private Button saveTask;
    private Task task;
    private TasksDAO tasksDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String uuid;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        uuid = getIntent().getStringExtra("uuid");
        tasksDAO = new TasksDAO(getSharedPreferences("Default",MODE_PRIVATE));
        task = tasksDAO.getTasksById(uuid);

        textEditTask = (TextView) findViewById(R.id.textEditTask);
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(task.getmTitle());
        saveTask = (Button) findViewById(R.id.saveTask);
        editText.getText();
        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.setmTitle(editText.getText().toString());
                tasksDAO.editTask(task);
                finish();
            }
        });
    }
}
