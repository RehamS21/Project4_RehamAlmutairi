package com.example.healthcaresystem_project4.Repository;

import com.example.healthcaresystem_project4.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    Room findRoomById(Integer id);

}
