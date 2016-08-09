import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.endurance.training.dev.model.Customer;

/**
 * Hello world!
 *
 */
public class Demo3Main
{
    private static EntityManagerFactory emFactory;

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        emFactory = Persistence.createEntityManagerFactory("demo3");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Customer("Amisha"));
        em.persist(new Customer("Moiz"));
        em.persist(new Customer("Elita"));
        em.persist(new Customer("Nihal"));
        em.persist(new Customer("Parth"));

        em.getTransaction().commit();
        em.close();
        emFactory.close();

        System.exit(0);

    }
}
