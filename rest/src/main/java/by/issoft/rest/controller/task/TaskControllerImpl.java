package by.issoft.rest.controller.task;

import by.issoft.dto.PartyDto;
import by.issoft.dto.ProductDto;
import by.issoft.dto.UserDto;
import by.issoft.exception.NoEntityException;
import by.issoft.restApi.task.TaskController;
import by.issoft.restMapper.PartyResponseMapper;
import by.issoft.restMapper.TaskResponseMapper;
import by.issoft.restModel.TaskResponse;
import by.issoft.restModel.TaskStatusResponse;
import by.issoft.serviceApi.PartyService;
import by.issoft.serviceApi.ProductService;
import by.issoft.serviceApi.TaskService;
import by.issoft.serviceApi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {
    private final TaskService taskService;
    private final PartyService partyService;
    private final ProductService productService;
    private final UserService userService;
    private final TaskResponseMapper taskResponseMapper;
    private final PartyResponseMapper partyResponseMapper;

    @Autowired
    public TaskControllerImpl(TaskService taskService, PartyService partyService, ProductService productService, UserService userService, TaskResponseMapper taskResponseMapper, PartyResponseMapper partyResponseMapper) {
        this.taskService = taskService;
        this.partyService = partyService;
        this.productService = productService;
        this.userService = userService;
        this.taskResponseMapper = taskResponseMapper;
        this.partyResponseMapper = partyResponseMapper;
    }

    public List<TaskResponse> allTasks() {
        return taskResponseMapper.fromListDto(taskService.findAll());
    }

    public TaskResponse getById(Integer id) throws NoEntityException {
        return taskResponseMapper.fromDto(taskService.findById(id));
    }

    public void update(Integer id, TaskResponse newTask) {
        newTask.setId(id);
        taskService.save(taskResponseMapper.toDto(newTask));
    }

    public List<TaskResponse> findByUser(Integer userId) throws NoEntityException {
        UserDto userDto = userService.findById(userId);
        return taskResponseMapper.fromListDto(taskService.findAllByUser(userDto));
    }

    public void delete(Integer id) {
        taskService.deleteById(id);
    }

    public TaskResponse addNew(TaskResponse taskResponse) throws NoEntityException {
        PartyDto partyDto = partyService.findById(taskResponse.getParty().getId());
        taskResponse.setParty(partyResponseMapper.fromDto(partyDto));
        return taskResponseMapper.fromDto(taskService.save(taskResponseMapper.toDto(taskResponse)));
    }

    public List<TaskResponse> getTasksByPartyAndUser(Integer partyId, Integer userId) throws NoEntityException {
        PartyDto partyDto = partyService.findById(partyId);
        UserDto userDto = userService.findById(userId);
        return taskResponseMapper.fromListDto(taskService.findAllByUserAndParty(userDto, partyDto));
    }

    public TaskResponse CompleteTask(String money, TaskResponse task) {
        Double m = Double.parseDouble(money);
        task.setMoney(m);
        task.setStatus(TaskStatusResponse.READY);
        taskService.save(taskResponseMapper.toDto(task));
        return task;
    }

    public TaskResponse checkTask(Integer partyId,
                                  Integer productId) throws NoEntityException {
        PartyDto party = partyService.findById(partyId);
        ProductDto product = productService.findById(productId);
        return taskResponseMapper.fromDto(taskService.checkExistTask(party, product));
    }

}
