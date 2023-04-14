package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.ReservationService;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.service.custome.StudentService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.tm.ReservationTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResrvationFormController {
    public JFXComboBox cmbStatus;
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXComboBox cmbStudentId;

    @FXML
    private JFXComboBox   cmbRoomId;

    @FXML
    private JFXTextField txtStudent;

    @FXML
    private TableView<ReservationTm> tblReservation;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colStudenrId;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colStatus;
    public ReservationService reservationService;
    public RoomService roomService;
    public StudentService studentService;
    public void initialize() throws SQLException, ClassNotFoundException {
        this.reservationService= (ReservationService) ServiceFactory.getInstance().getService(ServiceTypes.RESEVATION);
        this.roomService= (RoomService) ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
        this.studentService= (StudentService) ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);
        reservationView();
        ObservableList<String> list=FXCollections.observableArrayList("Paid","Non-Paid");
        cmbStatus.setItems(list);

        LoadStudentIds();
        LoadRoomTypeId();
    }

    public void txtIdOnActionm(ActionEvent actionEvent) {
    }

    public void btnRegistaion(ActionEvent actionEvent) {
   /*if (roomService.q)*/
        /*ReservationDTO reservationDTO=new ReservationDTO(txtId.getText(),txtdate.getText(),txtStudent.getText());
        try {
            boolean isAdded=reservationService.saveReservatoin(reservationDTO);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Added").show();
                tblReservation.getItems().add(new ReservationTm(reservationDTO.getId(),reservationDTO.getDate(),reservationDTO.getStatus()));
            }else {
                new Alert(Alert.AlertType.ERROR,"No").show();
            }
        }catch (DuplicateException e){
            new Alert(Alert.AlertType.ERROR,"Reservation already saved ").show();
            txtId.selectAll();
            txtId.requestFocus();
        }*/
        //ReservationDTO reservationDTO=new ReservationDTO(txtId.getText(),txtdate.getText(),cmbStudentId.)
     /*Re*/
    }
    private void reservationView(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void btnUpdateOnACtion(ActionEvent actionEvent) {
    }
    private void LoadStudentIds(){
        try {
            ObservableList<String>observableList= FXCollections.observableArrayList();
            ArrayList<String> idList=reservationService.loadAllStudentIds();

            for (String id: idList) {
                observableList.add(id);
            }
            cmbStudentId.setItems(observableList);
        }catch (SQLException |ClassNotFoundException e){
            throw new RuntimeException();
        }
    }
    private void LoadRoomTypeId(){
        try {
            ObservableList<String>observableList= FXCollections.observableArrayList();
            ArrayList<String> idList=reservationService.loadRoomTypeID();

            for (String id: idList) {
                observableList.add(id);
            }
            cmbRoomId.setItems(observableList);
        }catch (SQLException |ClassNotFoundException e){
            throw new RuntimeException();
        }
    }

}
