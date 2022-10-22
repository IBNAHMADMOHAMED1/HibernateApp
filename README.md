# HibernateApp
A Hibernate/JPA application that uses a MySQL database.

- If you want to setup a similar live template to the "jpa" template I use in the video, instructions on setting up live templates is [here](https://www.jetbrains.com/help/idea/using-live-templates.html). The "jpa" live template is configured with the following content:
```
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("$PERSISTENCEUNIT$");
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction transaction = entityManager.getTransaction();
try {
    transaction.begin();
	
    $END$
	
    transaction.commit();
} finally {
    if(transaction.isActive()) {
        transaction.rollback();
    }
    entityManager.close();
    entityManagerFactory.close();
}
```