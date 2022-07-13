package cinema.converters;

import cinema.dto.PurchasedTicket;
import cinema.dto.ReturnedTicket;
import cinema.dto.SeatDto;
import cinema.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TicketConverter {

    @Autowired
    private SeatConverter seatConverter;

    public PurchasedTicket convertToPurchasedTicket(Map.Entry<String, Seat> entryTicket) {
        return new PurchasedTicket(entryTicket.getKey(), seatConverter.convertToDto(entryTicket.getValue()));
    }

    public ReturnedTicket convertToReturnTicket(Seat seat) {
        ReturnedTicket ticket = new ReturnedTicket();
        ticket.setReturned_ticket(seatConverter.convertToDto(seat));
        return ticket;
    }


}
