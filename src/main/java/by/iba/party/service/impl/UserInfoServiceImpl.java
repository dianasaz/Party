package by.iba.party.service.impl;

import by.iba.party.entity.UserInfo;
import by.iba.party.repository.UserInfoRepository;
import by.iba.party.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public List<UserInfo> findAllByNameContains(String name) {
        return userInfoRepository.findAllByNameContains(name);
    }

    @Override
    public UserInfo save(UserInfo entity) {
        return userInfoRepository.save(entity);
    }

    @Override
    public Optional<UserInfo> findById(Integer id) {
        return userInfoRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return userInfoRepository.existsById(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userInfoRepository.deleteById(id);
    }
}
