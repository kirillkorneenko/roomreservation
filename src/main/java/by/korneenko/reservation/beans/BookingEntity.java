package by.korneenko.reservation.beans;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "roomreservation", catalog = "")
public class BookingEntity {
    private Long id;
    private int idEmployee;
    private int idRoom;
    private Date date;
    private Time timeStart;
    private Time timeEnf;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idEmployee")
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Basic
    @Column(name = "idRoom")
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "timeStart")
    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "timeEnf")
    public Time getTimeEnf() {
        return timeEnf;
    }

    public void setTimeEnf(Time timeEnf) {
        this.timeEnf = timeEnf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return id == that.id &&
                idEmployee == that.idEmployee &&
                idRoom == that.idRoom &&
                Objects.equals(date, that.date) &&
                Objects.equals(timeStart, that.timeStart) &&
                Objects.equals(timeEnf, that.timeEnf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idEmployee, idRoom, date, timeStart, timeEnf);
    }
}
