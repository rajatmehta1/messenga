drop database messengadb;
create database messengadb;

use messengadb;

create table IF NOT EXISTS users (
   user_id INT AUTO_INCREMENT primary key,
   user_name varchar(10) NOT NULL,
   email varchar(100) NULL
)ENGINE=innodb;

create table if not exists chatrooms (
    room_id INT AUTO_INCREMENT primary key,
    room_name VARCHAR(100) NOT NULL,
    room_desc TEXT NOT NULL
)ENGINE=innodb;

create table if not exists user_chatrooms (
    usr_room_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    room_id INT NOT NULL,
    FOREIGN KEY (user_id)
    REFERENCES users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (room_id)
    REFERENCES chatrooms (room_id) ON DELETE CASCADE
)

create table if not exists connections (
    connection_id INT AUTO_INCREMENT primary key,
    user_id INT NOT NULL,
    ip_port VARCHAR(50) NOT NULL,
    STATUS CHAR(1) NOT NULL,
    FOREIGN KEY (user_id) references users (user_id) on delete cascade
)