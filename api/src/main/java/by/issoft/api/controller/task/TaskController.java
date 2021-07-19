package by.issoft.api.controller.task;

import by.issoft.dto.PartyDto;
import by.issoft.dto.ProductDto;
import by.issoft.dto.TaskDto;
import by.issoft.dto.UserDto;
import by.issoft.dto.TaskStatus;
import by.issoft.exception.NoEntityException;
import by.issoft.serviceModule.service.PartyService;
import by.issoft.serviceModule.service.ProductService;
import by.issoft.serviceModule.service.TaskService;
import by.issoft.serviceModule.service.UserService;
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
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, PartyService partyService, ProductService productService, UserService userService) {
        this.taskService = taskService;
        this.partyService = partyService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public List<TaskDto> allTasks() {
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public TaskDto getById(@PathVariable Integer id) throws NoEntityException {
        return taskService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody TaskDto newTaskDto) {
        newTaskDto.setId(id);
        taskService.save(newTaskDto);
    }

    @GetMapping(value = "/by-user/{userId}")
    public List<TaskDto> findByUser(@PathVariable Integer userId) throws NoEntityException {
        UserDto userDto = userService.findById(userId);
        return taskService.findAllByUser(userDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        taskService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public TaskDto addNew(@RequestBody TaskDto taskDto) throws NoEntityException {
        PartyDto partyDto = partyService.findById(taskDto.getParty().getId());
        taskDto.setParty(partyDto);
        return taskService.save(taskDto);
    }

    @GetMapping(value = "/party/{partyId}/user/{userId}")
    public List<TaskDto> getTasksByPartyAndUser(@PathVariable Integer partyId, @PathVariable Integer userId) throws NoEntityException {
        PartyDto partyDto = partyService.findById(partyId);
        UserDto userDto = userService.findById(userId);
        return taskService.findAllByUserAndParty(userDto, partyDto);
    }

    @PostMapping(value = "/{task}/{money}")
    public TaskDto CompleteTask(@PathVariable(value = "money") String money, @PathVariable(value = "task") TaskDto task) {
        Double m = Double.parseDouble(money);
        task.setMoney(m);
        task.setStatus(TaskStatus.READY);
        taskService.save(task);
        return task;
    }

    @GetMapping(value = "/check/{partyId}/{productId}")
    public TaskDto checkTask(@PathVariable Integer partyId,
                          @PathVariable Integer productId)  throws NoEntityException {
        PartyDto party = partyService.findById(partyId);
        ProductDto product = productService.findById(productId);
        return taskService.checkExistTask(party, product);
    }

}
