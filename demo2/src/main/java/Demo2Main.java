import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.endurance.training.dev.model.Customer;

/**
 * Hello world!
 *
 */
public class Demo2Main 
{
    private static SessionFactory sessionfactory;
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        sessionfactory = new Configuration().configure().buildSessionFactory();
        
        Session session = sessionfactory.openSession();
        session.beginTransaction();
        session.save(new Customer("Jay"));
        session.save(new Customer("Sanchari"));
        session.save(new Customer("Shivaprasad"));
        session.save(new Customer("Saikat"));
        session.save(new Customer("Swetha"));
        session.getTransaction().commit();
        session.close();
        
        sessionfactory.close();
        
        System.exit(0);

    }
}
