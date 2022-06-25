package com.talendig.springboottalendig.thirdpartyapi.feignclient.service;

import com.talendig.springboottalendig.thirdpartyapi.feignclient.client.FeignClient;
import com.talendig.springboottalendig.thirdpartyapi.feignclient.model.TodoData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private FeignClient feignClient;

    public List<TodoData> getTodos() {
        return feignClient.findAll();
    }
}
