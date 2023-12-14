package com.learning.servof.model.dto;

import com.learning.servof.model.audit.AbstractEntity;
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
public class UsersProblemsDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private AppUserDto appUserDto;
    private ProblemDto problemDto;
}
