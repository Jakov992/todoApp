package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.model.Todo;
import com.example.todo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("taskList", assignmentService.getAllTasks());
        System.out.println("Tu smo rođaci");
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        return "assignment/index";
    }

    @GetMapping("/addNewTask")
    public String getAddNewEmployeeForm(Model model) {
        model.addAttribute("task", assignmentService.getNewTask());
        return "assignment/save_task";
    }

    @GetMapping("/updateTask")
    public String showFormUpdate(@RequestParam(name = "id") Long taskId, Model model) {
        model.addAttribute("task", assignmentService.getTaskById(taskId));
        return "assignment/save_task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        assignmentService.saveTask(task);
        redirectAttributes.addFlashAttribute("message", "Task successfuly saved!");
        return "redirect:/";
    }

    @GetMapping("/viewTodos")
    public String viewTodos(@RequestParam(name = "taskId") Long taskId, Model model) {
        Task task = assignmentService.getTaskById(taskId);
        model.addAttribute("task", task);
        model.addAttribute("todoList", assignmentService.getAllTodosFromTask(task));
        return "assignment/todo_list";
    }

    @GetMapping("/addNewTodo")
    public String getAddNewTodoForm(@RequestParam(name = "taskId") Long taskId, Model model) {
        model.addAttribute("todo", assignmentService.getNewTask());
        model.addAttribute("task", assignmentService.getTaskById(taskId));
        return "assignment/save_todo";
    }

    @GetMapping("/updateTodo")
    public String showFormUpdateTodo(@RequestParam(name = "taskId") Long taskId,
                                     @RequestParam(name = "id") Long todoId,
                                     Model model) {
        model.addAttribute("todo", assignmentService.getTodoById(todoId));
        model.addAttribute("task", assignmentService.getTaskById(taskId));
        return "assignment/save_todo";
    }

    @PostMapping("/saveTodo/{taskId}")
    public String saveTodo(@ModelAttribute Todo todo,
                           @PathVariable(value = "taskId") Long taskId,
                           RedirectAttributes redirectAttributes) {
        System.out.println("******************************Ovo je todoId " + todo.getId());

        assignmentService.saveTodo(todo, taskId);
        redirectAttributes.addFlashAttribute("message", "TODO successfuly saved!");
        return "redirect:/viewTodos?taskId=" + taskId.toString(); // TODO: OVO ĆEMO PROMINIT DA VRATI NA TODO LIST OD TASK-A
    }
}
