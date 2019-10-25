package com.test.project.service;


import com.test.project.model.Customer;
import com.test.project.model.Room;
import com.test.project.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void reserveARoom(Customer customer){

        Room roomAvailable = hotelRepository.findRoomById(4);

        roomAvailable.setReserved(true);
        roomAvailable.setCustomer(customer);

        hotelRepository.save(roomAvailable);

    }

    public void addRoom(Room room){
        hotelRepository.save(room);
    }

    public Room findRoomById(int roomNumber){
        return hotelRepository.findRoomById(roomNumber);
    }

    public List<Room> findRoomsByIsReserved(boolean isReserved) {
        return hotelRepository.findAllByIsReserved(isReserved);
    }

}
