package com.talendig.springboottalendig.thirdpartyapi.simpleclient.service;

import com.talendig.springboottalendig.thirdpartyapi.simpleclient.model.PostData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonPlaceholderService {

    private RestTemplate restTemplate;

    public JsonPlaceholderService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<PostData> getPosts() {
        //Tenemos que llamar al API de jsonplaceholder, al endpoint /posts
        //Aqui -> https://jsonplaceholder.typicode.com/posts
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", List.class);
    }

    public void addPost(PostData todoData) {
        HttpEntity<PostData> httpEntity = new HttpEntity<>(todoData);
        restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", httpEntity, PostData.class);

    }

    public void updatePost(Integer id, PostData todoData) {
        HttpEntity<PostData> httpEntity = new HttpEntity<>(todoData);
        restTemplate.put("https://jsonplaceholder.typicode.com/posts/"+id, httpEntity);
    }
}
