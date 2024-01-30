package hibernate.hibernate;

import java.util.logging.Level;
import java.util.logging.LogManager;

public class UserHibernateEnterprise 
{
    public static void main( String[] args )
    {
    	LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
    	HibernateEnterprise h = new HibernateEnterprise();
    	h.showProducts();
    }
}
