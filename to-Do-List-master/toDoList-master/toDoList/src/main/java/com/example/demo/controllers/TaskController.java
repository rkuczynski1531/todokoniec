package com.example.demo.controllers;

import com.example.demo.domain.Task;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

//    @Autowired
//    TaskService taskService;

//    @GetMapping("/tasks")
//    private List<Task> getAllTasks(){
//        return taskService.listAllTasks();
//    }
//
//    @GetMapping("/task/{id}")
//    private Task getTask(@PathVariable("id") int id){
//        return taskService.getTaskById(id);
//    }
//
//    @DeleteMapping("/task/{id}")
//    private void deleteTask(@PathVariable("id") int id){
//        taskService.deleteTask(id);
//    }
//
//    @PostMapping("/tasks")
//    private int saveTask(@RequestBody Task task){
//        taskService.saveOrUpdateTask(task);
//        return task.getId();
//    }
    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String listTasks(Model model){

        model.addAttribute("tasks", taskService.listAllTasks());

        return "tasks";
    }

    @RequestMapping("/task/{id}")
    public String getTask(@PathVariable Integer id, Model model){

        model.addAttribute("task", taskService.getTaskById(id));

        return "task";
    }

    @RequestMapping("/task/new")
    public String newProduct(Model model){
        model.addAttribute("task", new Task());
        return "taskform";
    }

    @RequestMapping("task/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("task", taskService.getTaskById(id));
        return "taskform";
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Task task){
        Task savedTask = taskService.saveOrUpdateTask(task);
        return "redirect:/task/" + savedTask.getId();
    }

    @RequestMapping("/task/delete/{id}")
    public String delete(@PathVariable Integer id){
        taskService.deleteTask(id);

        return "redirect:/";
    }

    @RequestMapping("/sortAsc")
    public String sortTasksByDateAsc(Model model){
//        taskService.findAllByOrderByDateAsc();
        model.addAttribute("tasks", taskService.findAllByOrderByDateAsc());
//        taskService.listAllTasks();
        return "tasks";
    }
}
