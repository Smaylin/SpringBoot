package com.talendig.springboottalendig.thirdpartyapi.feignclient.client;

import com.talendig.springboottalendig.thirdpartyapi.feignclient.model.TodoData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FeignClient {

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TodoData> findAll();

    @GetMapping(value = "/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TodoData findById(@PathVariable("id") int id);

    @PostMapping(path = "/todos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody TodoData todoData);

}
