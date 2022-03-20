package com.androidpprog2.crimenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private Button mAddTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TasksDAO tasksDAO = new TasksDAO(getSharedPreferences("Default",MODE_PRIVATE));
        mCrimeRecyclerView = (RecyclerView)findViewById(R.id.crimeList);
        mAddTaskButton = findViewById(R.id.addTaskButton);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(null));

        updateUI();

        mAddTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task("",false);
                tasksDAO.addTask(task);
                Intent intent = NewTask.newIntent(MainActivity.this,task.getmId(),false);
                startActivity(intent);
            }
        });

    }

    private void updateUI() {
        TasksDAO tasksDAO = new TasksDAO(getSharedPreferences("Default",MODE_PRIVATE));
        mAdapter = new CrimeAdapter(tasksDAO.getTasks());
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    //Adapter
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Task> mCrimes;

        public CrimeAdapter(List<Task> crimes){ mCrimes = crimes; }

        @Override
        public int getItemCount() { return mCrimes.size(); }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Task crime = mCrimes.get(position);
            holder.bind(crime);
        }
    }

    //ViewHolder
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Task mCrime;
        private TextView mTitleTextView;
        private CheckBox mCheckBox;
        private Button mButton;


        public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            TasksDAO tasksDAO = new TasksDAO(getSharedPreferences("Default",MODE_PRIVATE));
            itemView.setOnClickListener(this);
            mTitleTextView = itemView.findViewById(R.id.infoTitle);
            mCheckBox = itemView.findViewById(R.id.crime_solved);
            mButton = itemView.findViewById(R.id.edit_task);

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = NewTask.newIntent(MainActivity.this,mCrime.getmId(),true);
                    startActivity(intent);
                }
            });

            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    tasksDAO.changeTaskState(mCrime.getmId(),b);
                    System.out.println(b);
                    System.out.println(mCrime.getmId());
                }
            });
        }

        public void bind(Task crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mCheckBox.setChecked(mCrime.ismState());

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,
                    mCrime.getmTitle() + " clicked!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
