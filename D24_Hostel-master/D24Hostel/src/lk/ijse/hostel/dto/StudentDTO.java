package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



public class StudentDTO {
    private String studentId;
    private String StudentName;
    private String address;
    private int contact_number;
    private String date_of_birth;
    private String gender;

    public StudentDTO(String studentId, String studentName, String address, int contact_number, String date_of_birth, String gender) {
        this.studentId = studentId;
        StudentName = studentName;
        this.address = address;
        this.contact_number = contact_number;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
    }

    public StudentDTO() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", address='" + address + '\'' +
                ", contact_number=" + contact_number +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
