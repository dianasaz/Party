package by.iba.party.controller.task;

import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.Task;
import by.iba.party.entity.User;
import by.iba.party.service.PartyService;
import by.iba.party.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TaskService taskService;
    private final PartyService partyService;

    @Autowired
    public TaskController(TaskService taskService, PartyService partyService) {
        this.taskService = taskService;
        this.partyService = partyService;
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

    @GetMapping(value = "/by-user/{user_id}")
    public List<Task> findByUser(@PathVariable User user_id){
        return taskService.findAllByUser(user_id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        taskService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public Task addNew(@RequestBody Task task) {
        task.setParty(partyService.findById(task.getParty().getId()).get());
        taskService.save(task);
        return task;
    }

    @PostMapping(value = "/{task}/{money}")
    public Task addPrice(@PathVariable String money, @PathVariable Task task) {
        Double m = Double.parseDouble(money);
        task.setMoney(m);
        taskService.save(task);
        return task;
    }

    @GetMapping(value = "/check/{party}/{product}")
    public Task checkTask(@PathVariable Party party,
                          @PathVariable Product product) {
        return taskService.checkExistTask(party, product);
    }

}
