package by.iba.party.controller.task;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.TaskDto;
import by.iba.party.dto.UserDto;
import by.iba.party.entity.TaskStatus;
import by.iba.party.service.PartyService;
import by.iba.party.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<TaskDto> allTasks() {
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public TaskDto getById(@PathVariable Integer id) {
        return taskService.findById(id).orElse(new TaskDto());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody TaskDto newTaskDto) {
        newTaskDto.setId(id);
        taskService.save(newTaskDto);
    }

    @GetMapping(value = "/by-user/{user_id}")
    public List<TaskDto> findByUser(@PathVariable UserDto user_id){
        return taskService.findAllByUser(user_id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        taskService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public TaskDto addNew(@RequestBody TaskDto taskDto) {
        taskDto.setPartyDto(partyService.findById(taskDto.getPartyDto().getId()).get());
        return taskService.save(taskDto);
    }

    @GetMapping(value = "/party/{party}/user/{user}")
    public List<TaskDto> getTasksByPartyAndUser(@PathVariable PartyDto party, @PathVariable UserDto user){
        return taskService.findAllByUserAndParty(user, party);
    }

    @PostMapping(value = "/{task}/{money}")
    public TaskDto CompleteTask(@PathVariable(value = "money") String money, @PathVariable(value = "task") TaskDto task) {
        Double m = Double.parseDouble(money);
        task.setMoney(m);
        task.setStatus(TaskStatus.READY);
        taskService.save(task);
        return task;
    }

    @GetMapping(value = "/check/{party}/{product}")
    public TaskDto checkTask(@PathVariable PartyDto party,
                          @PathVariable ProductDto product) {
        return taskService.checkExistTask(party, product);
    }

}
