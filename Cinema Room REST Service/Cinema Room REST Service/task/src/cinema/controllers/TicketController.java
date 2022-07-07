package cinema.controllers;

import cinema.converters.TicketConverter;
import cinema.dto.RequestTicket;
import cinema.exceptions.MessageException;
import cinema.model.CinemaRoom;
import cinema.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class TicketController {
    private final CinemaRoom cinemaRoom = new CinemaRoom(9, 9);
    private final TicketConverter ticketConverter = new TicketConverter();

    @GetMapping("/seats")
    public CinemaRoom getSeats() {
        return cinemaRoom;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody RequestTicket requestTicket) {
        Optional<Map.Entry<String, Ticket>> ticket = cinemaRoom.purchaseTicket(requestTicket);
        if (ticket.isEmpty()) {
            return new ResponseEntity<>(
                    new MessageException("The number of a row or a column is out of bounds!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (ticket.get().getValue().isPurchased()) {
            return new ResponseEntity<>(
                    new MessageException("The ticket has been already purchased!"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticketConverter.convertToResponse(ticket.get()), HttpStatus.OK);
    }
}
