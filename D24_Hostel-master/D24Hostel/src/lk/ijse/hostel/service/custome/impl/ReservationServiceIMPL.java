package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custome.ReservationDAO;
import lk.ijse.hostel.dao.custome.StudentDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.entity.ReservationEntity;
import lk.ijse.hostel.service.custome.ReservationService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.util.Convertor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationServiceIMPL implements ReservationService {
    private final ReservationDAO reservationDAO;
    private final StudentDAO studentDAO;
    private  final Convertor convertor;

    public ReservationServiceIMPL() {
        reservationDAO= (ReservationDAO) DAOFactory.getInstance().getDAO(DaoTypes.RESEVATION);
        studentDAO= (StudentDAO) DAOFactory.getInstance().getDAO(DaoTypes.STUDENT);
        convertor=new Convertor();
    }

    @Override
    public boolean saveReservatoin(ReservationDTO reservationDTO) throws DuplicateException {
        System.out.println(reservationDTO+"");
        //return reservationDAO.save(convertor.toRe(reservationDTO));
      return reservationDAO.save(new ReservationEntity(reservationDTO.getId(), reservationDTO.getDate(), reservationDTO.getStatus()));
    }

    @Override
    public ArrayList<String> loadAllStudentIds() throws SQLException, ClassNotFoundException {
        return studentDAO.loadStudentIdS();
    }
}
