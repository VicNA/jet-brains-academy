package cinema.dto;

public class ReturnedTicket {
    private SeatDto returned_ticket;

    public ReturnedTicket(SeatDto returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public SeatDto getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(SeatDto returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
