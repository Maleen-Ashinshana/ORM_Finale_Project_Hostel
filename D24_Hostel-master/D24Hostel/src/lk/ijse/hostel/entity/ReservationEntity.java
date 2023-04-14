package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
@ToString
public class ReservationEntity implements SuperEntity {
    @Id
    private String id;
    private String Date;
    private String status;
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private StudentEntity studentEntity;
    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_type_id")
    private RoomEntity room;

    public ReservationEntity(String id, String date, String status) {
        this.id = id;
        Date = date;
        this.status = status;
    }

    public ReservationEntity(String id, String date, String status, StudentEntity studentEntity, RoomEntity roomEntity, String status1) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
