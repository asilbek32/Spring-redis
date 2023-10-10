package com.company.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@Getter
@Setter
public class ProfileDTO implements Serializable {
    private Integer id;
    private String name;
    private String surname;
}
