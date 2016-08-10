import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

import com.endurance.training.dev.model.Customer;
import com.endurance.training.dev.model.Hobby;

/**
 * Hello world!
 *
 */
public class Demo5Main
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

        List<Customer> customers = em
                .createQuery("select c from Customer c", Customer.class)
                .getResultList();

        for (Customer cust : customers)
        {
            Set<Hobby> custHobbies = cust.getHobbies();
            System.out.println(cust.getName());
            System.out.println("Number of hobbies for " + cust.getName() + " = " + custHobbies.size());

        }

        CriteriaQuery<Hobby> criteriaQuery = em.getCriteriaBuilder()
                .createQuery(Hobby.class);
        Root<Hobby> root = criteriaQuery.from(Hobby.class);
        criteriaQuery.select(root);
        List<Hobby> hobbies = em.createQuery(criteriaQuery).getResultList();

        for (Hobby h : hobbies)
        {
            Set<Customer> cWithThisHobby = h.getCustomers();
            System.out.println(h.getDescription());

        }

        em.close();
        emFactory.close();

        System.exit(0);

    }
}
