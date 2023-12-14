package com.learning.servof.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatutResponse implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;

}
