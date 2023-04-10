package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
@Entity
@ToString
@Table(name = "reservation")
public class ReservationEntity implements SuperEntity {
    @Id
    private String id;
    private Date Date;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id")
    private StudentEntity studentEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation-Id")
    private RoomEntity room;


    public ReservationEntity(String id, java.sql.Date date, String status) {
        this.id = id;
        Date = date;
        this.status = status;
    }

    public ReservationEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
