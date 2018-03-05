package com.arajit.coding.challenge.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class IndexService {
  
  private static Logger logger = LoggerFactory.getLogger(IndexService.class);
  
  @Autowired
  RestClient restClient;
  
  @Autowired
  ObjectMapper jsonMapper;
  
  
  /**
   * Create a new index with the name {@code indexName}. The
   * index settings and mappings can be provided using the {@code requestBody}
   *
   * @param indexName   The name of the index to create
   * @param requestBody The mappings and settings for the index to be created
   */
  public void createIndex(String indexName, String requestBody) {
      try {
        //XmlMapper xmlMapper = new XmlMapper();
        //JsonNode node = xmlMapper.readTree(requestBody.getBytes());
        
        //System.out.println("node:"+node.toString());

        String requestBodyJson =converXmlToJson(requestBody);
        System.out.println("requestBodyJson:"+requestBodyJson);
          HttpEntity entity =  new NStringEntity(requestBodyJson,ContentType.APPLICATION_JSON);
          Response response = restClient.performRequest(
                  "PUT",
                  indexName,
                  Collections.<String, String>emptyMap(),
                  entity);

          int statusCode = response.getStatusLine().getStatusCode();
          System.out.println("statusCode::"+statusCode);
          if (statusCode > 299) {
              logger.warn("Problem while creating an index: {}", response.getStatusLine().getReasonPhrase());
              //throw new QueryExecutionException("Could not create index, status code is " + statusCode);
          }

      } catch (UnsupportedEncodingException e) {
          logger.warn("Problem converting the request body into an http entity");
          //throw new IndexApiException("Problem converting the request body into an http entity", e);
      } catch (IOException e) {
         e.printStackTrace();
          logger.warn("Problem creating new index.");
          //throw new IndexApiException("Problem creating new index", e);
      }
  }

  protected String converXmlToJson(final String requestXml) {
   // JSONObject jObject = XML.toJSONObject(requestXml);
    //jsonMapper.writeValueAsString(node);
    return XML.toJSONObject(requestXml).toString();
  }
}
