package com.demo.service;

import java.util.List;

import com.demo.conf.TaskModel;
import com.demo.util.TasksUtil;

public class TaskService {

    /**
     * getting initial tasks
     * 
     * @return
     */
    public List<TaskModel> getInitialTasks() {
        return TasksUtil.getTasks();
    }

    public List<TaskModel> addTasks(TaskModel model) {
        return TasksUtil.addTasks(model);
    }
}
