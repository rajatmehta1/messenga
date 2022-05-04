package com.sv.messenga.repository;

import com.sv.messenga.MessengaApplication;
import com.sv.messenga.pos.Room;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yml")
public class RoomRepositoryTests {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void saveNewRoom() {
        Room r = new Room();
             r.setRoomName("Green Card");
             r.setRoomDesc("Green card room");

             roomRepository.save(r);
        Assert.assertNotNull(r);
    }


}
