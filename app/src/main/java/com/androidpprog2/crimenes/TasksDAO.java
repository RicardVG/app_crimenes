package com.androidpprog2.crimenes;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TasksDAO {

    private final String DATA_KEY = "data";
    private SharedPreferences sh;
    private Gson gson;

    public TasksDAO(SharedPreferences sh) {
        this.sh = sh;
        this.gson = new Gson();
    }

    public List<Task> getTasks(){
        String json = sh.getString(DATA_KEY,"");
        if (json.equals("")) {
            json = sh.getString(DATA_KEY,getDefaultJson());
        }
        Task[] taskArray = gson.fromJson(json,Task[].class);
        setTasks(Arrays.asList(taskArray));
        return Arrays.asList(taskArray) ;
    }

    public void setTasks(List<Task> tasks){
        String tasksJson = gson.toJson(tasks);
        SharedPreferences.Editor editor = sh.edit();
        editor.putString(DATA_KEY,tasksJson);
        editor.apply();
    }

    public void addTask(Task task){
        List<Task> tasks = getTasks();
        tasks.add(task);
        setTasks(tasks);
    }

    public void editTask(Task task){
        List<Task> tasks = getTasks();
        for (Task t: tasks) {
            if (t.getmId().equals(task.getmId())){
                t.setmTitle(task.getmTitle());
            }
        }
        setTasks(tasks);
    }

    public Task getTasksById(String uuid){
        List<Task> tasks = getTasks();
        for (Task t: tasks) {
            if (t.getmId().equals(uuid)){
                return t;
            }
        }
        return null;
    }

    private String getDefaultJson(){
        List<Task> list = new ArrayList<>();
        list.add(new Task("Sacar al Perro",false));
        list.add(new Task("Comprar el Pan",false));
        list.add(new Task("Revisar el correo de la Salle",false));
        list.add(new Task("Preparar reuniones del dia",false));
        list.add(new Task("Hacer ejercicio",false));
        return gson.toJson(list);
    }

    public void changeTaskState(String uuid, boolean checked){
        List<Task> tasks = getTasks();
        for (Task t: tasks) {
            if (t.getmId().equals(uuid)){
                t.setmState(checked);
            }
        }
        setTasks(tasks);
    }
}
