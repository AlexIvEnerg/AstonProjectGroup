import comparator.CarModelComparator;
import comparator.CarPowerComparator;
import comparator.CarYearComparator;
import model.Car;
import sorting.EvenOddSort;

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
        //sorting.SelectionSort strategy = new sorting.SelectionSort();
        //strategy.sort(cars, comparatorYear);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
    }
}
