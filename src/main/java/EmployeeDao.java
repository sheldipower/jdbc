import java.util.List;

public interface EmployeeDao {
    void createEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void changeEmployeeById(int id);
    void dropEmployeeById(int id);
}