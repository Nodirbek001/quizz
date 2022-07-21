package ui;

import confic.HibernateConfigurer;
import domains.user.Login;
import domains.user.Name;
import domains.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class UI {
    public static void main() {
        createUser();
    }

    public static void getUserByID(Long id){
        Session session = HibernateConfigurer.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.getTransaction().commit();
        session.close();
    }

    public static long createUser() {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(User.builder()
                .login(Login.builder()
                        .username("Hi")
                        .password("M4")
                        .email("muhammad@gmail.com")
                        .build())
                .name(Name.builder()
                        .firstname("Muhammad")
                        .middleName("Abdullah")
                        .lastname("Mubarak")
                        .build())
                .build());
        session.getTransaction().commit();
        session.close();
        return 1L;
    }
}
