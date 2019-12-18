package by.iba.party.service.impl;

import by.iba.party.entity.*;
import by.iba.party.repository.TaskRepository;
import by.iba.party.service.TaskService;
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
    public List<Task> findAllByParty(Party party) {
        return taskRepository.findAllByParty(party);
    }

    @Override
    public List<Task> findAllByProduct(Product product) {
        return taskRepository.findAllByProduct(product);
    }


    @Override
    public List<Task> findAllByUser(User userInfo) {
        return taskRepository.findAllByUser(userInfo);
    }


    @Override
    public List<Task> findAllByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public Task checkExistTask(Party party, Product product) {
        return taskRepository.findByPartyAndProduct(party, product);
    }

    @Override
    public Task save(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public Optional<Task> findById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return taskRepository.existsById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }
}
