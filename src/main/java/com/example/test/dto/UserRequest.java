package com.example.test.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserRequest implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String position;

    private String phone;
}
