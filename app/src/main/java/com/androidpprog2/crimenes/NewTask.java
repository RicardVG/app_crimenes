package com.androidpprog2.crimenes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewTask extends AppCompatActivity {

    public static Intent newIntent(Context packageContext, String uuid, Boolean edit) {
        Intent intent = new Intent(packageContext, NewTask.class);
        intent.putExtra("uuid",uuid);
        intent.putExtra("edit",edit);
        return intent;
    }

    private TextView textEditTask;
    private Button saveTask;
    private Task task;
    private TasksDAO tasksDAO;
    private boolean mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String uuid;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        uuid = getIntent().getStringExtra("uuid");
        mEdit = getIntent().getBooleanExtra("edit",false);
        tasksDAO = new TasksDAO(getSharedPreferences("Default",MODE_PRIVATE));
        task = tasksDAO.getTasksById(uuid);

        textEditTask = (TextView) findViewById(R.id.textEditTask);
        if (!mEdit){
            textEditTask.setText("New Task");
        }
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(task.getTitle());
        saveTask = (Button) findViewById(R.id.saveTask);
        editText.getText();
        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.setTitle(editText.getText().toString());
                tasksDAO.editTask(task);
                finish();
            }
        });
    }
}
