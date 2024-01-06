package org.example.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseData {
    private Args args;

    private String data;

    private Args files;

    private Args form;

    private Headers headers;

    private String url;

    private Args json;
}
