package model;

import java.time.LocalDate;

public class Car {
    private final int power;
    private final String model;
    private final LocalDate releaseYear;

    public Car(int power, String model, LocalDate releaseYear) {
        this.power = power;
        this.model = model;
        this.releaseYear = releaseYear;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
