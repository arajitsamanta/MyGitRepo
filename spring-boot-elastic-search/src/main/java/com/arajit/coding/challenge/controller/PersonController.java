package com.arajit.coding.challenge.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.arajit.coding.challenge.config.ElasticSearchConfig;
import com.arajit.coding.challenge.domain.Person;
import com.arajit.coding.challenge.domain.PersonInfo;
import com.arajit.coding.challenge.service.IndexService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
  
  private static Logger logger = LoggerFactory.getLogger(PersonController.class);
  
  private static final String INDEX = "/persons";
  
  @Value(value = "classpath:Persons.xml")
  private Resource inputResource;
  
  @Autowired
  private IndexService indexService;
  
  @GetMapping(path = "/load")
  public void loadData() {
   System.out.println("Loading data..");
   
  

   try {
     String requestBody=StreamUtils.copyToString( inputResource.getInputStream(), Charset.defaultCharset() );
     System.out.println("request body:"+requestBody);
     indexService.createIndex(INDEX, requestBody);
  } catch (IOException e) {
    logger.error("Error in ceraring index, ", INDEX);
    e.printStackTrace();
  }
    
  }
  
  @GetMapping(path = "/search/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public PersonInfo search(@PathVariable(name="employeeId") String employeeId) {
    System.out.println("searching employee data.."+employeeId);
    
    PersonInfo temp=new PersonInfo();
    Person p=new Person();
    p.setName("John Does");
    temp.setPerson(p);
    return temp;
  }
  
}
