package com.dudka.io.task2.calculateFineAmountByType;

import java.util.Objects;

public class CalculateFine {
    private Double fullFineAmount;
    private String fineType;

    public CalculateFine(Double fullFineAmount, String fineType) {
        this.fullFineAmount = fullFineAmount;
        this.fineType = fineType;
    }

    public CalculateFine() {
    }

    public Double getFullFineAmount() {
        return fullFineAmount;
    }

    public void setFullFineAmount(Double fullFineAmount) {
        this.fullFineAmount = fullFineAmount;
    }

    public String getFineType() {
        return fineType;
    }

    public void setFineType(String fineType) {
        this.fineType = fineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculateFine)) return false;
        CalculateFine that = (CalculateFine) o;
        return Double.compare(that.getFullFineAmount(), getFullFineAmount()) == 0 && Objects.equals(getFineType(), that.getFineType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullFineAmount(), getFineType());
    }

    @Override
    public String toString() {
        return "CalculateFine{" +
                "fullFineAmount=" + fullFineAmount +
                ", fineType='" + fineType + '\'' +
                '}';
    }
}
