package com.dudka.courses.task2.entity;

import com.dudka.courses.task2.annotation.CustomProperty;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class Person {
    @CustomProperty
    private String nickname;
    @CustomProperty
    private Integer daysOfMembership;
    @CustomProperty(name = "joinDateTime")
    private Instant joinDate;

    public Person(String nickname, Integer daysOfMembership, Instant joinDate) {
        this.nickname = nickname;
        this.daysOfMembership = daysOfMembership;
        this.joinDate = joinDate;
    }

    public Person() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getDaysOfMembership() {
        return daysOfMembership;
    }

    public void setDaysOfMembership(Integer daysOfMembership) {
        this.daysOfMembership = daysOfMembership;
    }

    public Instant getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Instant joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getDaysOfMembership() == person.getDaysOfMembership() && getNickname().equals(person.getNickname()) && getJoinDate().equals(person.getJoinDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNickname(), getDaysOfMembership(), getJoinDate());
    }

    @Override
    public String toString() {
        return "Person{" +
                "nickname='" + nickname + '\'' +
                ", daysOfMembership=" + daysOfMembership +
                ", joinDate=" + joinDate +
                '}';
    }
}
