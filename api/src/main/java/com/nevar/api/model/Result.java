package com.nevar.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private int status;
    private String message;
    private Object data;
}
