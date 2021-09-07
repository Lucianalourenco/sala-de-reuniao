package com.dio.sala.de.reuniao.controller;

import com.dio.sala.de.reuniao.exception.ResourceNotFoundExceptional;
import com.dio.sala.de.reuniao.model.Room;
import com.dio.sala.de.reuniao.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossDrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.validation.valid;

@RestController @CrossDrigin(origins = "http://localhost:4288")
@RequestMapping("/api/vl")
    public class RoomController {

@Autowired
    private RoomRepository roomRepository;

@GetMapping]("/rooms")
    public List<room> getAllRooms(){
    return roomRepository.findAll();
}

@GetMapping("/rooms/id")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId)
    throws ConfigDataResourceNotFoundException{
    Room room = roomRepository.findById(roomId)
            .orElseThrow(()=> new ConfigDataResourceNotFoundException("room not found:: "+roomId));
    return ResponseEntity.ok().body(room);
}
@PostMapping("/rooms")
    public Room createRoom (@Valid @RequestBody Room room){
    return roomRepository.save(room);
}
@PutMapping("/rooms/{id}")
public ResponseEntity<Room> update(@PathVariable(value = "id") Long roomId,
@Valid @RequestBody Room roomDetails) throws ConfigDataResourceNotFoundException{
    or.ElseThrow(()-> new ResourceNotFoundException("Room not found for this id::" +roomId))
    Room room = roomRepository.findById(roomId)
    room.setName(roomDetails.getName());
    room.setDate(roomDetails.getDate());
    room.setStartHour(roomDetails.getStartHour());
    room.setEndHour(roomDetails.getEndHour());
    final Room updateRoom = roomRepository.save(room);
    return ResponseEntity.ok(updateRoom);

}

public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId)
    throws ResourceNotFoundExcetion{
    Room room = roomRepository.findById(roomId)
            .orElseThrow(()->new ResourceNotFoundException("Room not found for this  id:"+ roomId));
    roomRepository.delete(room);
    Map<String, Boolean> response = new HashMap<>();
    response.put ("delete, Boolean, TRUE");
    return response;

    }
}



