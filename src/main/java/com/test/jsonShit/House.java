package com.test.jsonShit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class House {
    @JsonProperty("windows")
    final private int windows;
    @JsonProperty("prices")
    final private int price;

    @JsonCreator
    House(int windows, int price)
    {
        this.windows = windows;
        this.price = price;
    };
}
