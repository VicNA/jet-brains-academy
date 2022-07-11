package cinema.converters;

import cinema.dto.SeatDto;
import cinema.model.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatConverter {
    public SeatDto convertToDto(Seat seat) {
        SeatDto seatDto = new SeatDto();
        seatDto.setRow(seat.getRow());
        seatDto.setColumn(seat.getColumn());
        seatDto.setPrice(seat.getPrice());

        return seatDto;
    }
}
