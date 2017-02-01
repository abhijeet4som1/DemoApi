package com.demo.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.demo.conf.TaskModel;

public class TasksUtil {

    private static List<TaskModel> tasks;

    static {
        tasks = new ArrayList<TaskModel>();
        tasks.add(new TaskModel("Task 1", Calendar.getInstance().getTime()));
        tasks.add(new TaskModel("Task 2", Calendar.getInstance().getTime()));
        tasks.add(new TaskModel("Task 3", Calendar.getInstance().getTime()));
    }

    public static List<TaskModel> getTasks() {
        return tasks;
    }

    public static List<TaskModel> addTasks(TaskModel task) {
        tasks.add(task);
        return tasks;
    }

}
