package com.mycompany.model.entity;

import java.util.Objects;

public class NotebookEntity {
    private final String brand;
    private final Integer serialNumber;

    public NotebookEntity(String brand, int serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotebookEntity that = (NotebookEntity) o;
        return serialNumber == that.serialNumber &&
                Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, serialNumber);
    }

    @Override
    public String toString() {
        return "NotebookEntity{" +
                "brand='" + brand + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
