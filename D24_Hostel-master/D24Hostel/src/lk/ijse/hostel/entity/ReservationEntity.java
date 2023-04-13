package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class ReservationEntity implements SuperEntity {
    @Id
    private String id;
    private String Date;
    private String status;


    @ManyToOne
    private StudentEntity studentEntity;
    @ManyToOne()
    private RoomEntity room;

    public ReservationEntity(String id, String date, String status) {
        this.id = id;
        Date = date;
        this.status = status;
    }

    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_Id")
//    private StudentEntity studentEntity;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reservation-Id")
//    private RoomEntity room;

  /*  @ToString.Exclude
    @
    OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private StudentEntity studentEntity;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private RoomEntity room;*/

}
