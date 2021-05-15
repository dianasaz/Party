package by.iba.party.service.impl;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.TaskDto;
import by.iba.party.dto.UserDto;
import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.Task;
import by.iba.party.entity.User;
import by.iba.party.exception.NoEntityException;
import by.iba.party.mapper.PartyMapper;
import by.iba.party.mapper.ProductMapper;
import by.iba.party.mapper.TaskMapper;
import by.iba.party.mapper.UserMapper;
import by.iba.party.repository.TaskRepository;
import by.iba.party.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final PartyMapper partyMapper = PartyMapper.INSTANCE;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
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
