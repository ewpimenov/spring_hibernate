package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(new Car("Car1", 111));
        userService.add(user1);

        User user2 = new User("User1", "Lastname2", "user2@mail.ru");
        user1.setCar(new Car("Car2", 222));
        userService.add(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setCar(new Car("Car3", 333));
        userService.add(user3);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<Car> cars = userService.listCars();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("name = " + car.getName());
            System.out.println("series = " + car.getSeries());
            System.out.println();
        }

        context.close();
    }
}
