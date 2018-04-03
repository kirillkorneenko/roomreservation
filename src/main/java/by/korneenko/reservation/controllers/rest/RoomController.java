package by.korneenko.reservation.controllers.rest;

import by.korneenko.reservation.beans.RoomEntity;
import by.korneenko.reservation.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/room", produces = MediaType.APPLICATION_JSON_VALUE )
public class RoomController {

    RoomService roomService;

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    /*---Add new Room---*/
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody RoomEntity roomEntity) {
        roomService.save(roomEntity);
        //ID!!!!!
        return ResponseEntity.ok().body("Добавлена новая комната" );
    }

    /*---Get a Room by id---*/
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> get(@PathVariable("id") long id)  {
        RoomEntity room = roomService.getByKey(id);
        if(room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Команта не найдена");
        }
        return ResponseEntity.ok().body(room);
    }

    /*---Update a room by id---*/
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody RoomEntity room) {
        room.setId(id);
        roomService.update(room);
        return ResponseEntity.ok().body("Комната изменена успешно");
    }

    /*---Delete a room by id---*/
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        RoomEntity room = new RoomEntity();
        room.setId(id);
        roomService.delete(room);
        return ResponseEntity.ok().body("Комната удалена успешно");
    }
}
