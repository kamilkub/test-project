package com.test.project.service;

import com.test.project.model.Room;
import com.test.project.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.isNull;

@SpringBootTest
class HotelServiceTest {


    @Autowired
    private HotelRepository hotelRepository;



    @Test
    void reserveARoom() {


    }

    @Test
    void addRoom() {


    }

    @Test
    void checksIfRoomIsFoundById() {

        assertThat(Arrays.asList(hotelRepository.findRoomById(4)), hasSize(1));


    }



    @Test
    void checksIfRoomsAreFoundByWhetherTheyAreReservedOrNot() {

        List<Room> room = hotelRepository.findAllByIsReserved(true);

        assertThat(room.get(0).getCustomer().getFirstName(), equalTo("Kamil"));

    }
}