package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity           //저장소에 쓸 거로 만들어줌
public class Customer {
    @Id //이거는 id다.
    @GeneratedValue(strategy = GenerationType.AUTO) //알아서 관리
    private long id;
    private String firstName;
    private String lastName;

    protected Customer() { //상속받아서 사용할 일이 없음
        // 기본 생성자
    }
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName=%s. lastName=%s",
                id, firstName, lastName);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
