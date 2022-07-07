package cinema.converters;

import cinema.dto.ResponseTicket;
import cinema.dto.TicketDto;
import cinema.model.Ticket;

import java.util.Map;

public class TicketConverter {

    public ResponseTicket convertToResponse(Map.Entry<String, Ticket> entryTicket) {
        return new ResponseTicket(entryTicket.getKey(), convertToDto(entryTicket.getValue()));
    }

    private TicketDto convertToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setRow(ticket.getRow());
        ticketDto.setColumn(ticket.getColumn());
        ticketDto.setPrice(ticket.getPrice());
        return ticketDto;
    }
}
