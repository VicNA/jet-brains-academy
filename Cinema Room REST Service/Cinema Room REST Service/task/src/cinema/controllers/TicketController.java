package cinema.controllers;

import cinema.converters.CinemaRoomConverter;
import cinema.converters.SeatConverter;
import cinema.converters.TicketConverter;
import cinema.dto.CinemaRoomDto;
import cinema.dto.RequestSeat;
import cinema.dto.RequestTicket;
import cinema.exceptions.MessageException;
import cinema.model.CinemaRoom;
import cinema.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class TicketController {
    private final CinemaRoom cinemaRoom = new CinemaRoom(9, 9);
    @Autowired
    private TicketConverter ticketConverter;
    @Autowired
    private CinemaRoomConverter cinemaRoomConverter;
    @Autowired
    private SeatConverter seatConverter;

    @GetMapping("/seats")
    public CinemaRoomDto getSeats() {
        return cinemaRoomConverter.convertToDto(cinemaRoom);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody RequestSeat requestSeat) {
        Optional<Map.Entry<String, Seat>> ticket = cinemaRoom.purchaseTicket(requestSeat);
        if (ticket.isEmpty()) {
            return new ResponseEntity<>(
                    new MessageException("The number of a row or a column is out of bounds!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (ticket.get().getValue().isPurchased()) {
            return new ResponseEntity<>(
                    new MessageException("The ticket has been already purchased!"),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(ticketConverter.convertToResponse(ticket.get()), HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody RequestTicket ticket) {
        Optional<Seat> seat = cinemaRoom.getSeat(ticket.getToken());
        if (seat.isEmpty()) {
            return new ResponseEntity<>(
                    new MessageException("Wrong token!"),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                seatConverter.convertToDto(seat.get()),
                HttpStatus.OK);
    }
}
