package com.example.websiteDemoBackend.menuApi.application.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeListWrapper {
    private int code;
    private List<CoffeeDto> data;
}
