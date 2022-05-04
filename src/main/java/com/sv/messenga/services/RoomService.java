package com.sv.messenga.services;

import com.sv.messenga.dtos.RoomDTO;
import com.sv.messenga.pos.Room;
import com.sv.messenga.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    private RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDTO getRoom(Integer roomId) {
        Optional<Room> r = roomRepository.findById(roomId);
        if(r.isPresent()) {
            Room room = r.get();
            return new RoomDTO(room);
        } else {
            return null;
        }
    }


}
