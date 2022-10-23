import entity.Department;
import entity.Employee;

import jakarta.persistence.*;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.byDepartment", Employee.class);
            query.setParameter(1, 1);
            for (Employee employee : query.getResultList()) {
                System.out.println(employee.getFirstName() + " " + employee.getLastName());
            }


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
