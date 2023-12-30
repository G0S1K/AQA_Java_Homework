package org.example.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetResponseData {
    private Args args;

    private Headers headers;

    private String url;
}
