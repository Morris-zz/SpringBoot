package com.example.oppo.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.oppo.demo.enums.Permission;
import com.example.oppo.demo.domain.Person;
import com.example.oppo.demo.domain.User;
import com.example.oppo.demo.dto.DownLoadExcelDto;
import com.example.oppo.demo.repository.PersonRepository;
import com.example.oppo.demo.service.HrmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HrmController {
    protected static final Logger logger = LoggerFactory.getLogger(HrmController.class);
    @Autowired
    private HrmService hrmService;
    @Autowired
    private PersonRepository personRepository;

    @Value("${data.security.100w:}")
    private long a;
    @Value("${foreign:false}")
    private boolean is;
    /**
     * 基本搭建
     * @return
     */
    @RequestMapping(value = "/hrm",method = RequestMethod.GET)
    public Object hrm(@RequestParam(value = "id",required = false) Integer id,
                            @RequestParam(value = "tagValue" , required = false) String tagValue,
                            @RequestParam(value = "tagValueMap" , required = false) String tagValueMap,
                            @RequestParam(value = "tagId" , required = false) Long tagId,
                            @RequestParam(value = "tagValueDistribution" , required = false) Long tagValueDistribution,
                            @PageableDefault(value = 10,size = 10,direction = Sort.Direction.DESC,sort = {"id"}) Pageable pageable){
        Specification specification =  new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //创建Predicate的list,用于储存查询条件
                List<Predicate> predicates = new ArrayList<>();
                /** 校验非空 */
                if (id != null){
                    predicates.add(criteriaBuilder.equal(root.get("id"),id));
                }
                if (tagValue != null && !tagValue.equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("tagValue"),tagValue));
                }
                if (tagValueMap != null && !tagValueMap.equals("")){
                    predicates.add(criteriaBuilder.like(root.get("tagValueMap"),tagValueMap+"%"));
                }
                if (tagId != null){
                    predicates.add(criteriaBuilder.equal(root.get("tagId"),tagId));
                }
                if (tagValueDistribution != null){
                    predicates.add(criteriaBuilder.equal(root.get("tagValueDistribution"),tagValueDistribution));
                }
                return  criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };


        //Pageable pageable = PageRequest.of(0,3, Sort.Direction.DESC,"id");
        //Page<Person> all = personRepository.findAll(pageable);


        Page all = personRepository.findAll(specification, pageable);
        //System.out.println(is);

        List<User> list = new ArrayList<>();
        User user = new User("21","123","111");
        User user2 = new User("121","1123","1111");
        list.add(user);
        list.add(user2);
        for (User u :
                list) {
            u.setName("zzzzz");

        }

        return all;

    }

    /**
     * 获得所有hrm信息
     * @return
     */
    @RequestMapping(value = "/getAllHrm",method = RequestMethod.GET)
    public List<User> getAllHrm(@RequestParam(value = "a",required = false) String a){

        //System.out.println(a);
        System.out.println(hrmService.getAllHrm().get(0).getName());
        logger.info("test[{}]",hrmService.getAllHrm().get(0).getName());
        return hrmService.getAllHrm();
    }

    /**
     * 新增hrm
     * @param name
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/addHrm")
    public User addHrm(@RequestParam("name") String name,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password){
        User user = new User(name,username,password);
        System.out.println(username);
        hrmService.addHrm(user);
        System.out.println();
        return hrmService.addHrm(user);
    }


    /**
     * 测试千万数据优化
     * @param tagId
     * @return
     */
    @GetMapping(value = "/getHrm")
    public List<Person> getById(@RequestParam("tag_id") Long tagId){
        StopWatch sw = new StopWatch("千万级数据优化测试");
        sw.start("查询开始");
        List<Person> personByTagid = hrmService.getPersonByTagid(tagId);
        sw.stop();

        System.out.println(sw.prettyPrint());
        return personByTagid;
    }
    /**
     * 测试千万数据优化
     * @param tagId
     * @return
     */
    @GetMapping(value = "/getRole")
    public List<Permission> getRole(@RequestParam(value = "tag_id",required = false) Long tagId){
        System.out.println(a);
        StopWatch sw = new StopWatch("千万级数据优化测试");
        sw.start("查询开始");
        List<Permission> personByTagid = hrmService.getRole();
        sw.stop();

        System.out.println(sw.prettyPrint());
        return personByTagid;
    }

    /**
     * 更新hrm信息
     * @return
     */
    @PutMapping(value = "/updateHrm/{id}")
    public User updateHrm(@RequestParam("name") String name,
                          @PathVariable("id") Integer id,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password){
        System.out.println(id);
        User user = new User(name,username,password);
        user.setId(id);
        return hrmService.updateHrm(user);
    }

    /**
     * 根据id删除hrm
     * @param id
     */
    @DeleteMapping(value = "/deletHrm/{id}")
    public void deletHrm(@PathVariable("id") Integer id){
        hrmService.deletHrm(id);
    }

    @PostMapping(value = "/findByName")
    public List<User> findByName(@RequestParam("name") String name){
        return hrmService.findByName(name);
    }



    @PostMapping(value = "/DownLoadExcel")
    public void downLoadExcel(@RequestBody DownLoadExcelDto dto){
        hrmService.getData(dto);
    }

    @GetMapping(value = "/getThirdTag")
    public Object getThirdTag(){
        JSONArray array = new JSONArray();
        for (int i =0;i<3 ;i++){
            JSONObject obj = new JSONObject();
            obj.put("id",1);
            obj.put("value","0-18"+i);
            array.add(obj);
        }
        return array;
    }

}






















