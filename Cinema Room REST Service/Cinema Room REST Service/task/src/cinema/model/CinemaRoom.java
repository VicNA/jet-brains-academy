package cinema.model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CinemaRoom {

    private int totalRows;
    private int totalColumns;
    private int currentIncome;
    private int availableSeats;
    private int purchasedTicket;
    private final ConcurrentHashMap<String, Seat> tickets = new ConcurrentHashMap<>();

    public CinemaRoom(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        initRoom();
        availableSeats = tickets.size();
    }

    private void initRoom() {
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                tickets.putIfAbsent(
                        UUID.randomUUID().toString(),
                        new Seat(i + 1, j + 1));
            }
        }
    }

    public Optional<Map.Entry<String, Seat>> findSeat(int row, int column) {
        return tickets.entrySet().stream()
                .filter(entry ->
                        entry.getValue().getRow() == row && entry.getValue().getColumn() == column)
                .findFirst();

    }

    public void purchaseTicket(Seat seat) {
        seat.setPurchased(true);
        availableSeats--;
        purchasedTicket++;
        currentIncome += seat.getPrice();
    }

    public Optional<Seat> returnTicket(String token) {
        Seat seat = tickets.get(token);
        if (seat != null) {
            seat.setPurchased(false);
            availableSeats++;
            purchasedTicket--;
            currentIncome -= seat.getPrice();
        }

        return Optional.ofNullable(seat);
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public Map<String, Seat> getTickets() {
        return Collections.unmodifiableMap(tickets);
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getPurchasedTicket() {
        return purchasedTicket;
    }
}
