package com.sv.messenga.dtos;

import com.sv.messenga.pos.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

    private Integer userId;
    private String screenName;
    private String email;
    private String phone;

    public UserDTO() {

    }

    public UserDTO(User u) {
        this.userId = u.getId();
        this.email = u.getEmail();
        this.screenName = u.getUserName();
        this.phone = ""; // TODO
    }

}
