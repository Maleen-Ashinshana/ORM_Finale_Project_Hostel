package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationTm {


        private String id;
        private String date;
        //    private StudentDTO student;
//    private RoomDTO room;
        private String status;
}
