import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.endurance.training.dev.model.Customer;

/**
 * Hello world!
 *
 */
public class Demo1Main 
{
    private static SessionFactory sessionfactory;
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        sessionfactory = new Configuration().configure().buildSessionFactory();
        
        Session session = sessionfactory.openSession();
        session.beginTransaction();
        session.save(new Customer("Geetali"));
        session.save(new Customer("Neha"));
        session.save(new Customer("Rahul"));
        session.save(new Customer("Madhumita"));
        session.save(new Customer("Vandan"));
        session.getTransaction().commit();
        session.close();
        
        sessionfactory.close();
        
        System.exit(0);

    }
}
