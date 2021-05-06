package by.iba.party.service.impl;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.TaskDto;
import by.iba.party.dto.UserDto;
import by.iba.party.entity.*;
import by.iba.party.repository.TaskRepository;
import by.iba.party.service.TaskService;
import by.iba.party.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> findAllByUser(UserDto userInfoDto) {
        User user = ModelMapperUtil.map(userInfoDto, User.class);
        return ModelMapperUtil.mapList(taskRepository.findAllByUser(user), TaskDto.class);
    }

    @Override
    public TaskDto checkExistTask(PartyDto partyDto, ProductDto productDto) {
        Party party = ModelMapperUtil.map(partyDto, Party.class);
        Product product = ModelMapperUtil.map(productDto, Product.class);
        return ModelMapperUtil.map(taskRepository.findByPartyAndProduct(party, product), TaskDto.class);
    }

    @Override
    public List<TaskDto> findAllByUserAndParty(UserDto userDto, PartyDto partyDto) {
        User user = ModelMapperUtil.map(userDto, User.class);
        Party party = ModelMapperUtil.map(partyDto, Party.class);
        return ModelMapperUtil.mapList(taskRepository.findAllByUserAndParty(user, party), TaskDto.class);
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Task task = ModelMapperUtil.map(taskDto, Task.class);
        return ModelMapperUtil.map(taskRepository.save(task), TaskDto.class);
    }

    @Override
    public Optional<TaskDto> findById(Integer id) {
        return Optional.of(ModelMapperUtil.map(taskRepository.findById(id), TaskDto.class));
    }

    @Override
    public List<TaskDto> findAll() {
        return ModelMapperUtil.mapList(taskRepository.findAll(), TaskDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

}
