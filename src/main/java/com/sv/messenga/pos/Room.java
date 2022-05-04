package com.sv.messenga.pos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "chatrooms")
@Data
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer roomId;

    @Column(name = "room_name")
    public String roomName;

    @Column(name = "room_desc")
    public String roomDesc;

}
