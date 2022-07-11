package cinema.converters;

import cinema.dto.CinemaRoomDto;
import cinema.model.CinemaRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class CinemaRoomConverter {
    @Autowired
    private SeatConverter seatConverter;

    public CinemaRoomDto convertToDto(CinemaRoom room) {
        CinemaRoomDto roomDto = new CinemaRoomDto();
        roomDto.setTotal_rows(room.getTotal_rows());
        roomDto.setTotal_columns(room.getTotal_columns());
        roomDto.setAvailable_seats(
                room.getTickets().values().stream()
                        .map(seatConverter::convertToDto)
                        .collect(Collectors.toList()));

        return roomDto;
    }
}
