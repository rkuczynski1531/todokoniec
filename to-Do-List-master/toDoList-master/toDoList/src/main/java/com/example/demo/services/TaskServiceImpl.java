package com.example.demo.services;

import com.example.demo.domain.Task;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> listAllTasks() {
        List<Task> tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task saveOrUpdateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);

    }

    @Override
    public List<Task> findAllByOrderByDateAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "date");
        return taskRepository.findAllByOrderByDateAsc();
    }

    //    private Map<Integer, Task> tasks;
//
//    public TaskServiceImpl(){
//        loadTasks();
//    }
//
//    @Override
//    public List<Task> listAllTasks() {
//        return new ArrayList<>(tasks.values());
//    }
//
//    @Override
//    public Task getTaskById(Integer id) {
//        return tasks.get(id);
//    }
//
//    @Override
//    public Task saveOrUpdateTask(Task task) {
//        if (task != null){
//            if (task.getId() == null){
//                task.setId(getNextKey());
//            }
//            tasks.put(task.getId(), task);
//
//            return task;
//        } else {
//            throw new RuntimeException("task Can't be null");
//        }
//    }
//
//    private Integer getNextKey(){
//        return Collections.max(tasks.keySet()) + 1;
//    }
//
//    @Override
//    public void deleteTask(Integer id) {
//        tasks.remove(id);
//    }
//
//    private void loadTasks(){
//        tasks = new HashMap<>();
//
//        Task task1 = new Task();
//        task1.setId(1);
//        task1.setDescription("aaa");
//
//        tasks.put(1, task1);
//    }
}
