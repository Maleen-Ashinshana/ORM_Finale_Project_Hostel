package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationService extends SuperSevice {
    boolean saveReservatoin(ReservationDTO reservationDTO) throws DuplicateException;

    ArrayList<String> loadAllStudentIds() throws SQLException,ClassNotFoundException;
}
