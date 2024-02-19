import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>(10);
        carList.add(new Car("Toyota Camry", 25000.0, 2022));
        carList.add(new Car("Honda Accord", 23000.0, 2021));
        carList.add(new Car("Ford Mustang", 35000.0, 2020));
        carList.add(new Car("Chevrolet Malibu", 24000.0, 2019));
        carList.add(new Car("Nissan Altima", 26000.0, 2022));
        carList.add(new Car("BMW 3 Series", 40000.0, 2018));
        carList.add(new Car("Mercedes-Benz C-Class", 42000.0, 2020));
        carList.add(new Car("Audi A4", 38000.0, 2021));
        carList.add(new Car("Hyundai Sonata", 22000.0, 2019));
        carList.add(new Car("Volkswagen Passat", 28000.0, 2017));

        chooseOption(carList);
    }

    private static void chooseOption(List<Car> carList) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Отсортировать машины по цене от меньшего к большему");
            System.out.println("2. Отсортировать машины по цене от большего к меньшему");
            System.out.println("3. Отсортировать машины по году выпуска от меньшего к большему");
            System.out.println("4. Отсортировать машины по году выпуска от большего к меньшему");
            System.out.println("5. Получить рандомную машину");
            System.out.println("0. Выход");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    carList.sort(Comparator.comparingDouble(Car::getPrice));
                    printCarList(carList);
                    break;
                case 2:
                    carList.sort((car1, car2) -> Double.compare(car2.getPrice(), car1.getPrice()));
                    printCarList(carList);
                    break;
                case 3:
                    carList.sort(Comparator.comparingInt(Car::getYear));
                    printCarList(carList);
                    break;
                case 4:
                    carList.sort((car1, car2) -> Integer.compare(car2.getYear(), car1.getYear()));
                    printCarList(carList);
                    break;
                case 5:
                    Car randomCar = carList.get(random.nextInt(carList.size()));
                    System.out.println("Рандомная машина: " + randomCar);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверная опция. Попробуйте снова.");
            }
        }

    }


    private static void printCarList(List<Car> carList) {
        System.out.println("Отсортированный список машин:");
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }
}

