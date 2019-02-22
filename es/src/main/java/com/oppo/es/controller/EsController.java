package com.oppo.es.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.oppo.es.dao.ArticleRepository;
import com.oppo.es.pojo.Article;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.elasticsearch.index.query.QueryBuilders.*;
import java.util.*;

@RestController
public class EsController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void add(){
        Article article = new Article();
        Math.random();
        article.setId(1l);
        article.setAbstracts("1234");
        article.setTitle("zz");
        article.setPostTime(new Date());
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");

        articleRepository.save(article);
    }



    @PostMapping(value = "/map")
    public void map(@RequestBody Map requsetMap){
       List<Map> mapList = (List<Map>) requsetMap.get("selectCondition");

        for (Map map:mapList) {
//            Iterable<map.Entry<String,String>> iterable = map.entrySet().iterator();
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = it.next();
                System.out.println(entry.getKey()+"----"+entry.getValue());
            }
        }
    }


    @RequestMapping(value = "/q",method = RequestMethod.GET)
    public List<Article> getEs(){
        String queryString = "springboot";//搜索关键字

        HashMap map = new HashMap();

        Set set = map.entrySet();
        map.forEach((key, value) -> {
            System.out.println(key+"  "+value);
        });
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        List<Article> list = new ArrayList<>();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            list.add(iterator.next());
        }
        return list;


    }
    @RequestMapping(value = "/qq",method = RequestMethod.GET)
    public List<Article> getEs2(){
//        JSONPObject
return null;

    }


}
