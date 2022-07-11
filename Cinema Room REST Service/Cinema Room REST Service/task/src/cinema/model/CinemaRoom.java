package cinema.model;

import cinema.dto.RequestSeat;
import cinema.dto.RequestTicket;
import cinema.dto.SeatDto;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CinemaRoom {

    private int total_rows;
    private int total_columns;
    private final ConcurrentHashMap<String, Seat> tickets = new ConcurrentHashMap<>();

    public CinemaRoom(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        initRoom();
    }

    private void initRoom() {
        for (int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_columns; j++) {
                tickets.putIfAbsent(
                        UUID.randomUUID().toString(),
                        new Seat(i + 1, j + 1));
            }
        }
    }

    public Optional<Map.Entry<String, Seat>> purchaseTicket(RequestSeat requestSeat) {
        return tickets.entrySet().stream()
                .filter(entry ->
                        entry.getValue().getRow() == requestSeat.getRow()
                                && entry.getValue().getColumn() == requestSeat.getColumn())
                .peek(entry -> {
                    if (!entry.getValue().isPurchased()) entry.getValue().setPurchased(true);
                })
                .findFirst();

    }

    public Optional<Seat> getSeat(String token) {
        return Optional.ofNullable(tickets.get(token));
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

    public ConcurrentHashMap<String, Seat> getTickets() {
        return tickets;
    }
}
