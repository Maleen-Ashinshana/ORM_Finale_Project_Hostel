package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custome.ReservationDAO;
import lk.ijse.hostel.dao.custome.RoomDAO;
import lk.ijse.hostel.dao.custome.StudentDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.entity.ReservationEntity;
import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.service.custome.ReservationService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.util.Convertor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationServiceIMPL implements ReservationService {
    private final ReservationDAO reservationDAO;
    private final StudentDAO studentDAO;
    private final RoomDAO roomDAO;
    private  final Convertor convertor;

    public ReservationServiceIMPL() {
        reservationDAO= (ReservationDAO) DAOFactory.getInstance().getDAO(DaoTypes.RESEVATION);
        studentDAO= (StudentDAO) DAOFactory.getInstance().getDAO(DaoTypes.STUDENT);
        roomDAO= (RoomDAO) DAOFactory.getInstance().getDAO(DaoTypes.ROOM);
        convertor=new Convertor();
    }

    @Override
    public boolean saveReservatoin(ReservationDTO reservationDTO) throws DuplicateException {
        System.out.println(reservationDTO+"");
        //return reservationDAO.save(convertor.toRe(reservationDTO));
      //return reservationDAO.save(new ReservationEntity(reservationDTO.getId(), reservationDTO.getDate(), reservationDTO.getStatus()));
     //return reservationDAO.save(convertor.fromReservation(reservationDTO));
        //return reservationDAO.save(new ReservationEntity(reservationDTO.getId(),reservationDTO.getDate(),reservationDTO.getStatus(),reservationDTO.getStudentId(),reservationDTO.getRoomId()));

    ReservationEntity entity=new ReservationEntity(reservationDTO.getId(),reservationDTO.getDate(),reservationDTO.getStatus(),new StudentEntity(reservationDTO.getStudent()),new RoomEntity(reservationDTO.getRoom()));
    return reservationDAO.save(entity);

    }

    @Override
    public ArrayList<String> loadAllStudentIds() throws SQLException, ClassNotFoundException {
        return studentDAO.loadStudentIdS();
    }

    @Override
    public ArrayList<String> loadRoomTypeID() throws SQLException, ClassNotFoundException {
        return roomDAO.loadRoomsIds();
    }

    @Override
    public List<ReservationDTO> getAll() {
        return reservationDAO.getAll().stream().map(reservationEntity -> convertor.toReservation(reservationEntity)).collect(Collectors.toList());
    }

    @Override
    public ArrayList<String> loadRoomsType() {
        return roomDAO.loadRoomsType();
    }
}
