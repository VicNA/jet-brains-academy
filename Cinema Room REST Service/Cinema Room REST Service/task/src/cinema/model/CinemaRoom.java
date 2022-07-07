package cinema.model;

import cinema.dto.RequestTicket;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CinemaRoom {

    private int total_rows;
    private int total_columns;
    private List<Ticket> available_tickets;
    private final ConcurrentHashMap<String, Ticket> tickets = new ConcurrentHashMap<>();

    public CinemaRoom(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        initRoom();
    }

    private void initRoom() {
        available_tickets = new ArrayList<>();
        for (int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_columns; j++) {
                tickets.putIfAbsent(
                        UUID.randomUUID().toString(),
                        new Ticket(i + 1, j + 1));
            }
        }
    }

    public Optional<Map.Entry<String, Ticket>> purchaseTicket(RequestTicket requestTicket) {
        return tickets.entrySet().stream()
                .filter(entry ->
                        entry.getValue().getRow() == requestTicket.getRow()
                                && entry.getValue().getColumn() == requestTicket.getColumn())
                .peek(entry -> {
                    if (!entry.getValue().isPurchased()) entry.getValue().setPurchased(true);
                })
                .findFirst();

    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Ticket> getAvailable_seats() {
        return available_tickets;
    }
}
