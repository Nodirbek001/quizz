package quiz.dao;



import org.hibernate.Session;
import quiz.config.HibernateConfigurer;
import quiz.domain.user.User;
import quiz.response.Response;

public class UserDAO extends GenericDAO<User>{
    private static UserDAO instance;

    public static Response<User> getByUsername(String i_username){
        Session session = HibernateConfigurer.getSessionFactory().openSession();
        session.getTransaction().begin();
        User result = session.createQuery("select t from User t where t.login.username = :usernama", User.class)
                .setParameter("usernama", i_username).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return new Response<>(result);
    }

    public static UserDAO getInstance() {
        if (instance==null) {
            instance=new UserDAO();
        }
        return instance;
    }
}
