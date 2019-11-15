package by.iba.party.service;

import by.iba.party.entity.UserInfo;

import java.util.List;

public interface UserInfoService extends Service<UserInfo> {
    List<UserInfo> findAllByNameContains(String name);
}
