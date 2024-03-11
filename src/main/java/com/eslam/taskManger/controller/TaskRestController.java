package com.eslam.taskManger.controller;


import com.eslam.taskManger.entity.Task;
import com.eslam.taskManger.entity.User;
import com.eslam.taskManger.service.TaskService;
import com.eslam.taskManger.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/")
public class TaskRestController {
    private TaskService taskService;
    private UserService userService;
    private HttpSession session;

    @Autowired
    public TaskRestController(TaskService taskService,HttpSession session,UserService userService) {
        this.userService=userService;
        this.taskService = taskService;
        this.session=session;
    }

    @GetMapping("/")
    public String def(){
        return "redirect:/tasks";
    }
    @GetMapping("/tasks")
    public String listTasks(Model model){
        User user= (User) session.getAttribute("user");
        if (user==null)
            return "redirect:/login";
        if (user.isAdmin())
            model.addAttribute("admin",1);

        List<Task> tasks = taskService.findUserTasks(user.getId());
        if (tasks.isEmpty())
            model.addAttribute("empty",1);
        else
            model.addAttribute("empty",0);

        model.addAttribute("tasks",tasks);
        model.addAttribute("name",user.getFirstName());
        return "index";
    }
    @GetMapping("/add_task")
    public String addTask(Model model){
        Task task = new Task();
        User user= (User) session.getAttribute("user");
        model.addAttribute("task",task);
        if(user.isAdmin())
            model.addAttribute("admin",1);
        else {
            model.addAttribute("admin",0);
            model.addAttribute("user_id", user.getId());
        }
        return "task_form";
    }
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task){
        User user= (User) session.getAttribute("user");
        System.out.println(task);
        System.out.println("task user id " + task.getUser_id());
        System.out.println("user id " + user.getId());
        if (task==null ||(task.getUser_id()!=user.getId() && !user.isAdmin()))
        {
            return "redirect:/access-denied";
        }
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/update_task")
    public String updateTaskForm(@RequestParam("id") int id,Model model){
        User user= (User) session.getAttribute("user");
        Task task = taskService.findById(id);
        System.out.println(task);
        if (task==null ||(task.getUser_id()!=user.getId() && !user.isAdmin()))
        {
            return "redirect:/access-denied";
        }
        model.addAttribute("task",task);
        model.addAttribute("user_id",task.getUser_id());

        return "task_form";
    }
    @GetMapping("complete_task")
    public String comleteTask(@RequestParam("id") int id){
        Task task = taskService.findById(id);
        task.setStatus("Completed");
        taskService.save(task);
        return "redirect:/tasks";
    }
    @GetMapping("/admin-complete_task")
    public String adminComleteTask(@RequestParam("id") int id){
        Task task = taskService.findById(id);
        task.setStatus("Completed");
        taskService.save(task);
        return "redirect:/dashboard";
    }
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") int id,Model model){
        User user= (User) session.getAttribute("user");
        Task task=taskService.findById(id);
        if (task==null ||(task.getUser_id()!=user.getId() && !user.isAdmin()))
        {
            return "redirect:/access-denied";
        }
        taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/dashboard")
    public String adminIndex(Model model){
        User user= (User) session.getAttribute("user");
        if (!user.isAdmin()){
            return "redirect:/access-denied";
        }
        List<Task> tasks = taskService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("tasks",tasks);
        model.addAttribute("users",users);
        return "admin-index";
    }
}
