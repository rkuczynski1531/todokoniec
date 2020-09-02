package com.example.demo.services;

import com.example.demo.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> listAllTasks();

    Task getTaskById(Integer id);

    Task saveOrUpdateTask(Task task);

    void deleteTask(Integer id);

    Iterable<Task> findAllByOrderByDateAsc();
}
