import models.Auto;
import models.User;
import services.AutoService;
import services.UserService;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //doSomthing1();
        //doSomthing2();
        //doSomthing3();
        //doSomthing4();
        //doAutoSomthing();
        doAutoSomthing2();
    }

    public static void doAutoSomthing() {
        AutoService autoService = new AutoService();
        Auto ferrari = new Auto("Ferrari1", "red");
        autoService.saveAuto(ferrari);
    }

    public static void doAutoSomthing2() {
        AutoService autoService = new AutoService();
        UserService userService = new UserService();
        Auto auto = autoService.findAuto(8);
        auto.setUser(userService.findUser(5));
        autoService.updateAuto(auto);
    }

    public static void doSomthing1() throws SQLException {
        UserService userService = new UserService();
        User user = new User("Masha",30);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari1", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford1", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
    }
    public static void doSomthing2() throws SQLException {
        UserService userService = new UserService();
        User user = new User("Masha2", 28);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari2", "red");
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford2", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user.setName("Sasha2");
        userService.updateUser(user);
    }

    public static void doSomthing3() throws SQLException {
        UserService userService = new UserService();
        User user = new User("Masha3",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari3", "red");
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford3", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user.setName("Sasha3");
        userService.updateUser(user);
        userService.deleteUser(user);
    }

    public static void doSomthing4() throws SQLException {
        UserService userService = new UserService();
        List<User> users = userService.findUsersByName("Masha");
        for (User user:users){
            System.out.println(user);
            List<Auto> autos=userService.findAutoByUser(user);
            for (Auto auto:autos){
                System.out.println("\t" + auto);
            }

        }
    }
}