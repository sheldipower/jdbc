import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Scanner scanner = new Scanner(System.in);

        employeeDao.createEmployee(new Employee("Денис", "Маляров", "Man", 40, 3));

        int runSoft = 0;
        while (runSoft != 6) {
            printMenu();
            switch (runSoft = scanner.nextInt()) {
                case 1:
                    System.out.println("Введите id интересующего сотрудника");
                    int id = scanner.nextInt();
                    Employee employee1 = employeeDao.getEmployeeById(id);
                    if (employee1 == null) {
                        System.out.println("Такого сотрудника не существует");
                    } else {
                        System.out.println(employee1);
                    }
                    break;
                case 2:
                    List<Employee> employees = employeeDao.getAllEmployees();
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;
                case 3:
                    System.out.println("Введите id сотрудника для редактирования");
                    id = scanner.nextInt();
                    Employee employee2 = employeeDao.getEmployeeById(id);
                    System.out.println("Введите новые данные сотрудника:");
                    System.out.println("Имя");
                    String first_name = scanner.nextLine();
                    System.out.println("Фамилия");
                    String last_name = scanner.nextLine();
                    System.out.println("Пол");
                    String gender = scanner.nextLine();
                    System.out.println("Возраст");
                    int age = scanner.nextInt();
                    System.out.println("id города");
                    int cityId = scanner.nextInt();
                    Employee employee3 = new Employee(first_name, last_name, gender, age, cityId);
                    employee3.setId(employee2.getId());
                    employeeDao.updateEmployeeById(employee3);
                    break;
                case 4:
                    System.out.println("Введите id сотрудника которого хотите удалить");
                    id = scanner.nextInt();
                    Employee employee4 = employeeDao.getEmployeeById(id);
                    employeeDao.deleteEmployeeById(employee4);
                    HibernateManager.closeEntityManagerFactory();
                    break;
                case 5:
                    System.out.println("Введите данные нового сотрудника:");
                    System.out.println("Имя");
                    String first_name1 = scanner.nextLine();
                    System.out.println("Фамилия");
                    String last_name1 = scanner.nextLine();
                    System.out.println("Пол");
                    String gender1 = scanner.nextLine();
                    System.out.println("Возраст");
                    int age1 = scanner.nextInt();
                    System.out.println("id города");
                    int cityId1 = scanner.nextInt();
                    Employee employeeFromScanner = new Employee(first_name1, last_name1, gender1, age1, cityId1);

                    employeeDao.createEmployee(employeeFromScanner);
                    break;
                case 6:
                default:
                    System.out.println("Данный вариант отсутствует");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что бы вы хотели сделать?:\n " +
                "1 - Поиск сотрудника \n " +
                "2 - Получить список всех сотрудников \n " +
                "3 - Изменить данные сотрудника \n " +
                "4 - Удалить сотрудника из базы \n " +
                "5 - Добавить сотрудника \n " +
                "6 - Выход");
    }
}