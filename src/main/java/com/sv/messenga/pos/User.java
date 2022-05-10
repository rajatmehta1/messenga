package com.sv.messenga.pos;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *  Reference to : https://www.baeldung.com/jpa-many-to-many
 */
@Data
@Entity
@Table(name = "users")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "chatroom_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private Set<Room> chatRooms = new HashSet<>();

}
