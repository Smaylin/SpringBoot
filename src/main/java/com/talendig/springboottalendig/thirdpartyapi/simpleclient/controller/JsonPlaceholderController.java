package com.talendig.springboottalendig.thirdpartyapi.simpleclient.controller;

import com.talendig.springboottalendig.thirdpartyapi.simpleclient.model.PostData;
import com.talendig.springboottalendig.thirdpartyapi.simpleclient.service.JsonPlaceholderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/thirdpartyapi/jsonplaceholder")
public class JsonPlaceholderController {

    private JsonPlaceholderService jsonPlaceholderService;

    //Inyeccion de dependencias por constructor
    public JsonPlaceholderController(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @GetMapping(path = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostData>> getPosts() {
        return ResponseEntity.ok(jsonPlaceholderService.getPosts());
    }

    @PostMapping(path="/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPost(@RequestBody PostData todoData) {
        jsonPlaceholderService.addPost(todoData);
        return ResponseEntity.ok().build();
    }
}
