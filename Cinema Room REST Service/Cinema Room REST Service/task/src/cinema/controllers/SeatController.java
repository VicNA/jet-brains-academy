package cinema.controllers;

import cinema.model.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {
    private final Room room = new Room(9, 9);

    @RequestMapping("/seats")
    public Room getRoom() {
        return room;
    }
}
