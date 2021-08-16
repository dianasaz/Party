package by.issoft.restApi.task;

import by.issoft.exception.NoEntityException;
import by.issoft.restModel.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping(value = "/tasks")
public interface TaskController {

    @GetMapping(value = "/all")
    List<TaskResponse> allTasks();

    @GetMapping(value = "/{id}")
    TaskResponse getById(@PathVariable Integer id) throws NoEntityException ;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void update(@PathVariable Integer id, @RequestBody TaskResponse newTaskResponse);

    @GetMapping(value = "/by-user/{userId}")
    List<TaskResponse> findByUser(@PathVariable Integer userId) throws NoEntityException;

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable Integer id);

    @PostMapping(value = "/add")
    TaskResponse addNew(@RequestBody TaskResponse TaskResponse) throws NoEntityException;

    @GetMapping(value = "/party/{partyId}/user/{userId}")
    List<TaskResponse> getTasksByPartyAndUser(@PathVariable Integer partyId, @PathVariable Integer userId) throws NoEntityException;
    @PostMapping(value = "/{task}/{money}")
    TaskResponse CompleteTask(@PathVariable(value = "money") String money, @PathVariable(value = "task") TaskResponse task);

    @GetMapping(value = "/check/{partyId}/{productId}")
    TaskResponse checkTask(@PathVariable Integer partyId,
                             @PathVariable Integer productId)  throws NoEntityException;

}
