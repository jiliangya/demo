package com.example.demo.utils;

import lombok.Data;
@Data
public class R<T> {
    private String code;
    private String msg;
    private T entity;
}
