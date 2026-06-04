import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Car> comparatorModel = new CarModelComparator();
        Comparator<Car> comparatorPower = new CarPowerComparator();
        Comparator<Car> comparatorYear = new CarYearComparator();
        Car[] cars = new Car[6];
        cars[0] = new Car(631, "BMW", LocalDate.of(1990, 1, 1));
        cars[1] = new Car(850, "AUDI", LocalDate.of(1970, 1, 1));
        cars[2] = new Car(577, "MERCEDES", LocalDate.of(1980, 1, 1));
        cars[3] = new Car(420, "PORCHE", LocalDate.of(1960, 1, 1));
        cars[4] = new Car(750, "FIAT", LocalDate.of(2000, 1, 1));
        cars[5] = new Car(107, "NISSAN", LocalDate.of(1999, 1, 1));
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println("После сортировки");
        EvenOddSort evenOddSort = new EvenOddSort();
        evenOddSort.evenOddSort(cars, comparatorPower);
        //SelectionSort strategy = new SelectionSort();
        //strategy.sort(cars, comparatorYear);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
    }
}
class Car {
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
class CarPowerComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getPower(), o2.getPower());
    }
}
class CarModelComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}
class CarYearComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getReleaseYear().compareTo(o2.getReleaseYear());
    }
}
class SelectionSort {
    public void sort(Car[] cars, Comparator<Car> comparator){
        for (int i = 0; i < cars.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cars.length; j++) {
                if (comparator.compare(cars[j], cars[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Car temp = cars[i];
            cars[i] = cars[minIndex];
            cars[minIndex] = temp;
        }
    }
}
class EvenOddSort {
    public void evenOddSort(Car[] cars, Comparator<Car> comparator) {
        for (int i = 0; i < cars.length - 1; i++) {
            if (cars[i].getPower() % 2 != 0) {
                continue;
            } else {
                int minIndex = i;
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[j].getPower() % 2 == 0) {
                        if (comparator.compare(cars[j], cars[minIndex]) < 0) {
                            minIndex = j;
                        }
                    }
                }
                if (minIndex != i) {
                    Car temp = cars[i];
                    cars[i] = cars[minIndex];
                    cars[minIndex] = temp;
                }
            }
        }
    }
}
