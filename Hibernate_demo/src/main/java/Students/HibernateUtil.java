package Students;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//niezbedna jako punkt config polaczenia z hibernate
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        //tworzymy obiekt, ktory pobiera konfiguracje z pliku hibernate.cfg.xml
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        //Metadata to info dotyczace plikow z danych zaladowanych wczesniej
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder().build();

        //stworzenie sesji z danych zawartych w pliku hibernate.cfg.xml
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
