package com.talendig.springboottalendig.thirdpartyapi.simpleclient.model;

import lombok.Data;

@Data
public class PostData {

    private int userId;
    private int id;
    private String title;
    private String body;
}
