package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.ReservationService;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardFormController {
    public AnchorPane subpage;
    public JFXComboBox comType;
    public Label lblAllRooms;
    public Label lblCurrentRooms;
    public Label lblQty;
    public TableView tblRemain;
    public TableColumn colId;
    public TableColumn colname;
    public TableColumn colKyeMoney;
    public AnchorPane mainPane;
    public ReservationService reservationService;
    public RoomService roomService;

    public void initialize() throws SQLException, ClassNotFoundException {
        this.reservationService= (ReservationService) ServiceFactory.getInstance().getService(ServiceTypes.RESEVATION);
        this.roomService= (RoomService) ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
        loadRoomTypeId();
    }

    private void  loadAllRooms(){
        ObservableList<String> observableList=FXCollections.observableArrayList();
        //ArrayList<String> allList=roomService.getAllRoom();
    }

    private void loadRoomTypeId(){
        ObservableList<String> observableList= FXCollections.observableArrayList();
        ArrayList<String> idList=reservationService.loadRoomsType();

        for (String id: idList) {
            observableList.add(id);

        }
        comType.setItems(observableList);
    }
    private void fillRoomFile(RoomDTO roomDTO){
        lblQty.setText(String.valueOf(roomDTO.getQty()));
    }

    public void btnDashBoard(ActionEvent actionEvent) throws IOException {
     subpage.getChildren().clear();
     Navigation.navigate(Routes.DASHBOARD,mainPane);
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        subpage.getChildren().clear();
        Navigation.navigate(Routes.STUDENT,subpage);

    }

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        subpage.getChildren().clear();
        Navigation.navigate(Routes.ROOM,subpage);

    }

    public void btnReservationOnACtion(ActionEvent actionEvent) throws IOException {
        subpage.getChildren().clear();
        Navigation.navigate(Routes.RESERVATION,subpage);
    }

    public void cmbTypeOnActoin(ActionEvent actionEvent) {
        RoomDTO roomDTO=roomService.searchRoom(String.valueOf(comType.getValue()));
        if (roomDTO!=null){
            fillRoomFile(roomDTO);
        }

    }
}
