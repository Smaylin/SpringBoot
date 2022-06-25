package com.talendig.springboottalendig.thirdpartyapi.feignclient.model;

import lombok.Data;

@Data
public class TodoData {

    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
