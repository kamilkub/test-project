package com.test.project.repository;

import com.test.project.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Room, Integer> {

     Room findRoomById(int roomNumber);
     List<Room> findAllByIsReserved(boolean isReserved);


}
