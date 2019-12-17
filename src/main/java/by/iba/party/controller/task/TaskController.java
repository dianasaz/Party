package by.iba.party.controller.task;

import by.iba.party.entity.Task;
import by.iba.party.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/all")
    public List<Task> allTasks() {
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Task getById(@PathVariable Integer id) {
        return taskService.findById(id).orElse(new Task());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody Task newTask) {
        newTask.setId(id);
        taskService.save(newTask);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        taskService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public Task addNew(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

}
