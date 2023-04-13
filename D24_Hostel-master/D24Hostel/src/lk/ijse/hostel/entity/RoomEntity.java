package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

@NoArgsConstructor
@Table(name = "room")
public class RoomEntity implements SuperEntity {
    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
    /*@OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationEntities;*/
   /* @OneToMany(mappedBy = "room",targetEntity = ReservationEntity.class)
    private List<ReservationEntity> list = new ArrayList<>();*/

    public RoomEntity(String room_type_id, String type, String key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }
}
