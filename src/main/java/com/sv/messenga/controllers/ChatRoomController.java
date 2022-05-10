package com.sv.messenga.controllers;

import com.sv.messenga.dtos.RoomDTO;
import com.sv.messenga.dtos.UserDTO;
import com.sv.messenga.services.RoomService;
import com.sv.messenga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/m")
@RestController
public class ChatRoomController {

    private RoomService roomService;
    private UserService userService;

    @Autowired
    public ChatRoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(path = "/room/{roomId}",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public String addUserToRoom(@PathVariable(name = "roomId") Integer roomId,
                                @RequestBody(required = true) UserDTO userDTO) {
        roomService.addUserToRoom(roomId,userDTO.getUserId());
        return "User Added to Room";
    }

    @RequestMapping("/room/{room_id}")
    public RoomDTO getRoom(@PathVariable(name = "room_id") Integer roomId) {
        return this.roomService.getRoom(roomId);
    }

}
