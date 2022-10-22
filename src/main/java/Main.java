import entity.Department;
import entity.Employee;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Department department = new Department();
            department.setName("IT");
            entityManager.persist(department);
            Employee employee = new Employee();
            employee.setFirstName("John gg");
            employee.setLastName("Doe");
            employee.setDepartmentId(department.getId());
            entityManager.persist(employee);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
