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
import lk.ijse.hostel.service.custome.ReservationService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.tm.ReservationTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResrvationFormController {
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
    public void initialize(){
        reservationView();
    }

    public void txtIdOnActionm(ActionEvent actionEvent) {
    }

    public void btnRegistaion(ActionEvent actionEvent) {
        ReservationDTO reservationDTO=new ReservationDTO(txtId.getText(),txtdate.getText(),txtStudent.getText());
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
        }
        
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
}
