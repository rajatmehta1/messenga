package com.sv.messenga.services;

import com.sv.messenga.dtos.RoomDTO;
import com.sv.messenga.pos.Room;
import com.sv.messenga.pos.User;
import com.sv.messenga.repository.RoomRepository;
import com.sv.messenga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository,
                        UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
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


    @Transactional
    public void addUserToRoom(Integer roomId, Integer userId) {
        Optional<Room> room = roomRepository.findById(roomId);
        Optional<User> user = userRepository.findById(userId);

        if(null != room.get() && null != user.get()) {
            Room r = room.get();
            User u = user.get();
                u.getChatRooms().add(r);
                userRepository.save(u);
        }
//        room = null;
//        user = null;
    }
}
