package quiz.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
import quiz.config.HibernateConfigurer;
import quiz.domain.subject.Subject;
import quiz.domain.user.User;
import quiz.response.Response;

import java.util.List;

public class SubjectDAO extends GenericDAO<Subject> {
    private static SubjectDAO instance;

    public Response<List<Subject>> getSubject() {
        Session session = HibernateConfigurer.getSessionFactory().openSession();
        session.getTransaction().begin();

        List<Subject> resultList = session.createQuery("select t from Subject t where t.deleted = false ", Subject.class)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return new Response<>(resultList);
    }

    public void deleteSubject(int i_id) {
        Session session = HibernateConfigurer.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("update Subject  set deleted=1 where id=?1")
                .setParameter(1, i_id);

        session.getTransaction().commit();
        session.close();
    }



    public static SubjectDAO getInstance() {
        if (instance == null) {
            instance = new SubjectDAO();
        }
        return instance;
    }

}