package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;




public class ReservationDTO {
    private String id;
    private String date;
    private String status;
    private StudentDTO student;
    private RoomDTO room;

    public ReservationDTO() {
    }

    public ReservationDTO(String id, String date, String status, StudentDTO student, RoomDTO room) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
    }
}
