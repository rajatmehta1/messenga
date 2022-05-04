package com.sv.messenga.dtos;

import com.sv.messenga.pos.Room;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomDTO {

    private Integer roomId;
    private String roomName;
    private List<UserDTO> users;
    private String status;

    public RoomDTO() {
        this.users = new ArrayList<>();
    }

    public RoomDTO(Room room) {
        this.roomId = room.getRoomId();
        this.roomName = room.getRoomName();
    }

}
