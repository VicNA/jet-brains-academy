package cinema.dto;

public class ReturnedTicket {
    private TicketDto returned_ticket;

    public ReturnedTicket(TicketDto returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public TicketDto getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(TicketDto returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
