package com.sv.messenga.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDTO {

    private Integer userId;
    private String screenName;
    private String email;
    private String phone;

}
