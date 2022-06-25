package com.talendig.springboottalendig.thirdpartyapi.feignclient.controller;

import com.talendig.springboottalendig.thirdpartyapi.feignclient.model.TodoData;
import com.talendig.springboottalendig.thirdpartyapi.feignclient.service.TodoService;
import com.talendig.springboottalendig.thirdpartyapi.simpleclient.model.PostData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/demo/thirdpartyapi/feign/jsonplaceholder")
@AllArgsConstructor
public class FeignRestController {

    private final TodoService todoService;

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TodoData>> getPosts() {
        return ResponseEntity.ok(todoService.getTodos());
    }

}


