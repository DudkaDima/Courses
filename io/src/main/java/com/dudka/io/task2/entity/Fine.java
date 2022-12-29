package com.dudka.io.task2.entity;

import java.util.Objects;

public class Fine {
    private String type;
    private Double fineAmount;

    public Fine(String type, Double fineAmount) {
        this.type = type;
        this.fineAmount = fineAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fine)) return false;
        Fine fine = (Fine) o;
        return Double.compare(fine.getFineAmount(), getFineAmount()) == 0 && getType().equals(fine.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getFineAmount());
    }

    @Override
    public String toString() {
        return "Fine{" +
                "Type='" + type + '\'' +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
