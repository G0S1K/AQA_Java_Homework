package org.example.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseData {
    private Args args;

    private String data;

    private Files files;

    private Form form;

    private Headers headers;

    private String url;

    private JsonData json;
}
