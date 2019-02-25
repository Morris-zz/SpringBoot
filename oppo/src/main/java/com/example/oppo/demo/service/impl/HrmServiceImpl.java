package com.example.oppo.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.oppo.demo.enums.Permission;
import com.example.oppo.demo.domain.Person;
import com.example.oppo.demo.domain.User;
import com.example.oppo.demo.dto.DownLoadExcelDto;
import com.example.oppo.demo.repository.PersonRepository;
import com.example.oppo.demo.repository.UserRepository;
import com.example.oppo.demo.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HrmServiceImpl implements HrmService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonRepository personRepository;
    @Override
    public List<User> getAllHrm() {
        return userRepository.findAll();
    }

    @Override
    public User addHrm(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateHrm(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deletHrm(Integer id) {
         userRepository.deleteById(id);

    }

    @Override
    public List<User> findByName(String name) {
        Pageable pageable = (Pageable) PageRequest.of(0,5);
        return userRepository.findByName(name);
    }

    @Override
    public void getData(DownLoadExcelDto dto) {
        /**
         * fromCompany : insight
         * analyseMethod : 0
         * data : [{"title":"人口属性-基础属性-职业:中小学生(包含)","index_data":[{"data":[{"index":21288690,"val":"女"},{"index":13091055,"val":"男"},{"index":137643,"val":null}],"name":"性别"},{"data":[{"index":16021386,"val":"18～24"},{"index":14324738,"val":"25～34"},{"index":2829650,"val":"10～17"},{"index":1222434,"val":"35～49"},{"index":101169,"val":"50～70"},{"index":2,"val":null}],"name":"年龄"}]}]
         */
        //将页面数据转化为List存储
        List<Map<String,List<Map<String,String>>>> dataList = new ArrayList<>();
        System.out.println(dto.getData());
        JSONArray valueArray = JSONObject.parseArray(dto.getData());//将dto中的data取出变为数组
        JSONObject dataObject = (JSONObject) valueArray.get(0);//取出数组中的值（数组中只有一个值）
        JSONArray index_dataArray = (JSONArray) dataObject.get("index_data");//将“index_data”数组取出
        //遍历ataArray数组
        for (int i = 0 ; i < index_dataArray.size() ; i++){
            JSONObject dataArray  = (JSONObject) index_dataArray.get(i);//取出数组元素：{"data":[{"index":21288690,"val":"女"},{"index":13091055,"val":"男"},{"index":137643,"val":null}],"name":"性别"}
            String tagName = (String) dataArray.get("name");
            System.out.println(tagName);
            JSONArray excelDataArray = (JSONArray) dataArray.get("data");
            //建立List和Map
            List<Map<String,String>> dataMapList = new ArrayList<>();// 男;900,女：1000
            Map<String,String> dataMap = new HashMap<>();//男：900


            //遍历data，获取写入excel表中的数据
            for (int ii = 0 ; ii < excelDataArray.size() ; ii++){
                JSONObject data = (JSONObject) excelDataArray.get(ii);
                System.out.println(data.toString());
            }

        }
    }



    @Override
    @Cacheable(value = "PERSON",key = "#tagId+'_'")
    public List<Person> getPersonByTagid(Long tagId) {
        System.out.println("未通过缓存");
        return  personRepository.findByTagId(tagId);
    }

    @Override
    public List<Permission> getRole() {
        List<Permission> list = new ArrayList<>();
        list.add(Permission.ADMIN);
        list.add(Permission.USER);

        return list;
    }


}
