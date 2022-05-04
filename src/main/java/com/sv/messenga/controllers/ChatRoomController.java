package com.sv.messenga.controllers;

import com.sv.messenga.dtos.RoomDTO;
import com.sv.messenga.dtos.UserDTO;
import com.sv.messenga.repository.RoomRepository;
import com.sv.messenga.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/m")
@RestController
public class ChatRoomController {

    private RoomService roomService;

    @Autowired
    public ChatRoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public void addToRoom(Integer roomId, UserDTO userDTO) {

    }

    @RequestMapping("/room/{room_id}")
    public RoomDTO getRoom(@PathVariable(name = "room_id") Integer roomId) {
        return this.roomService.getRoom(roomId);
    }

}
