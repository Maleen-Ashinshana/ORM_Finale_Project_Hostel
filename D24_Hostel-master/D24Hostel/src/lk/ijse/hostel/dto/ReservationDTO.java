package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String id;
    private String date;
    private String status;
    private String student;
    private String room;

    public ReservationDTO(String id, String date, String status, StudentDTO studentDTO, RoomDTO roomDTO) {

    }
}
