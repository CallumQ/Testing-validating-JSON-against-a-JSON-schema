package com.test.jsonShit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    @JsonProperty("windows")
    private String name;

    @JsonCreator
    Cat(String name)
    {
        this.name = name;
    };
}
