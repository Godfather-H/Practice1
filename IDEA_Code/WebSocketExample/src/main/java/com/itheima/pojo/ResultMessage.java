package com.itheima.pojo;

import lombok.Data;

@Data
public class ResultMessage {
    private boolean System;
    private Object message;
    private String fromName;
}
