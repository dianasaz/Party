package by.issoft.service;

import by.issoft.dto.PartyDto;
import by.issoft.dto.ProductDto;
import by.issoft.dto.TaskDto;
import by.issoft.dto.UserDto;
import by.issoft.entity.Party;
import by.issoft.entity.Product;
import by.issoft.entity.Task;
import by.issoft.entity.User;
import by.issoft.exception.NoEntityException;
import by.issoft.mapper.PartyMapper;
import by.issoft.mapper.ProductMapper;
import by.issoft.mapper.TaskMapper;
import by.issoft.mapper.UserMapper;
import by.issoft.repository.TaskRepository;
import by.issoft.serviceApi.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;
    private final PartyMapper partyMapper;
    private final ProductMapper productMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UserMapper userMapper, PartyMapper partyMapper, ProductMapper productMapper){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userMapper = userMapper;
        this.partyMapper = partyMapper;
        this.productMapper = productMapper;
    }

    @Override
    public List<TaskDto> findAllByUser(UserDto userInfoDto) {
        User user = userMapper.fromDto(userInfoDto);
        return taskMapper.toListDto(taskRepository.findAllByUser(user));
    }

    @Override
    public TaskDto checkExistTask(PartyDto partyDto, ProductDto productDto) {
        Party party = partyMapper.fromDto(partyDto);
        Product product = productMapper.fromDto(productDto);
        return taskMapper.toDto(taskRepository.findByPartyAndProduct(party, product));
    }

    @Override
    public List<TaskDto> findAllByUserAndParty(UserDto userDto, PartyDto partyDto) {
        User user = userMapper.fromDto(userDto);
        Party party = partyMapper.fromDto(partyDto);
        return taskMapper.toListDto(taskRepository.findAllByUserAndParty(user, party));
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Task task = taskMapper.fromDto(taskDto);
        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public TaskDto findById(Integer id) throws NoEntityException {
        return taskMapper.toDto(taskRepository.findById(id).orElseThrow(() -> new NoEntityException(" No task with such id: " + id)));
    }

    @Override
    public List<TaskDto> findAll() {
        return taskMapper.toListDto(taskRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

}
