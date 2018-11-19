package Students;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public boolean saveStudentInDatabase(Student student){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            //otwiera tranzakcje
            transaction = session.beginTransaction();
            session.save(student);//zapis w bazie
            transaction.commit();
        }catch (SessionException se){
            //w razie bledu powrot do stanu z przed tranzakcji
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }
        return true;
    }
    public List<Student> getAllStudentsFromDatabase(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){

            Query<Student> query = session.createQuery("from Student st",Student.class);
            List<Student> students = query.list();
            return students;
        }catch (SessionException se){
            System.err.println("Nie udalo sie pobrac z bazy.");

        }
        return new ArrayList<>();
    }
}
