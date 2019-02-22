package com.example.oppo.demo.service;

import com.example.oppo.demo.domain.Permission;
import com.example.oppo.demo.domain.Person;
import com.example.oppo.demo.domain.User;
import com.example.oppo.demo.dto.DownLoadExcelDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * hrm接口
 */
@Service
public interface HrmService {
    List<User> getAllHrm();
    User addHrm(User user);
    User updateHrm(User user);
    void deletHrm(Integer id);
    List<User> findByName(String name);
    void getData(DownLoadExcelDto dto);
    List<Person> getPersonByTagid(Long tagId);
    List<Permission> getRole();

}
