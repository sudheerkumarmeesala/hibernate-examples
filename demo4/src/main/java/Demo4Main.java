import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.endurance.training.dev.model.Customer;
import com.endurance.training.dev.model.Hobby;

/**
 * Hello world!
 *
 */
public class Demo4Main
{
    private static EntityManagerFactory emFactory;

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        emFactory = Persistence.createEntityManagerFactory("demo4");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Customer("Amisha"));
        em.persist(new Customer("Moiz"));
        em.persist(new Customer("Elita"));
        em.persist(new Customer("Nihal"));

        Hobby hobby1 = new Hobby("Travel");
        Hobby hobby2 = new Hobby("TableTennis");
        
        em.persist(hobby1);

        Customer c = new Customer("Parth");
        Set<Hobby> cHobbies = new HashSet<Hobby>();
        cHobbies.add(hobby2);
        cHobbies.add(hobby1);
        c.setHobbies(cHobbies);
        
        em.persist(c);
        
        em.getTransaction().commit();
        em.close();
        emFactory.close();

        System.exit(0);

    }
}
