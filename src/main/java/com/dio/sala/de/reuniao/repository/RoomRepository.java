package com.dio.sala.de.reuniao.repository;

import com.dio.sala.de.reuniao.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface RoomRepository extends JpaRepository<Room, Long>{

}
