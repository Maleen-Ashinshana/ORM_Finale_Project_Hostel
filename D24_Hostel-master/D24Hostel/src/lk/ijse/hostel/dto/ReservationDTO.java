package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDTO {
    private String id;
    private Date date;
    private StudentDTO student;
    private RoomDTO room;
    private String status;
}
