import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Scanner scanner = new Scanner(System.in);

        employeeDao.createEmployee(new Employee("Денис", "Маляров", "Man", 40, 3));

        int runSoft = 0;
        while (runSoft != 5) {
            printMenu();
            switch (runSoft = scanner.nextInt()) {
                case 1:
                    System.out.println("Введите id интересующего сотрудника");
                    int id = scanner.nextInt();
                    Employee employee = employeeDao.getEmployeeById(id);
                    System.out.println(employee);
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
                    employeeDao.changeEmployeeById(id);
                    break;
                case 4:
                    System.out.println("Введите id сотрудника которого хотите удалить");
                    id = scanner.nextInt();
                    employeeDao.dropEmployeeById(id);
                    break;
                case 5:
                    break;
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
                "5 - Выход");
    }
}