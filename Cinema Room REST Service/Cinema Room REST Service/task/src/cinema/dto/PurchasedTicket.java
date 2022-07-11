package cinema.dto;

public class PurchasedTicket {
    private String token;
    private SeatDto ticket;

    public PurchasedTicket(String token, SeatDto ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SeatDto getTicket() {
        return ticket;
    }

    public void setTicket(SeatDto ticket) {
        this.ticket = ticket;
    }
}
