package com.example.healthcaresystem_project4.Repository;

import com.example.healthcaresystem_project4.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    Room findRoomById(Integer id);

    @Query("select r from Room r where r.roomtype =?1 ")
    List<Room> basedOnRoomType(String roomtype);

    @Query("select r from Room r order by r.roomtype asc ")
    List<Room> orderedRoom();




}
