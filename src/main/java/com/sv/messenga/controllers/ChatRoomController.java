package com.sv.messenga.controllers;

import com.sv.messenga.dtos.RoomDTO;
import com.sv.messenga.dtos.UserDTO;
import com.sv.messenga.exceptions.RoomNotFoundException;
import com.sv.messenga.pos.Room;
import com.sv.messenga.services.RoomService;
import com.sv.messenga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addUserToRoom(@PathVariable(name = "roomId") Integer roomId,
                                        @RequestBody(required = true) UserDTO userDTO) {
        roomService.addUserToRoom(roomId,userDTO.getUserId());
        return new ResponseEntity<>("User Added to Room", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/room/{room_id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRoom(@PathVariable(name = "room_id") Integer roomId) {
        try {
            RoomDTO room = this.roomService.getRoom(roomId);
            return new ResponseEntity(room, HttpStatus.OK);
        } catch(RoomNotFoundException re) {
            return new ResponseEntity<>(re.getMessage(),HttpStatus.CONFLICT);
        }
    }

}
