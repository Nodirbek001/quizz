package quiz.dao;
import org.hibernate.Session;
import quiz.config.HibernateConfigurer;
import quiz.domain.Domain;
import quiz.response.Response;

import java.lang.reflect.ParameterizedType;

public class GenericDAO <D extends Domain> {

    @SuppressWarnings("unchecked")
    private final Class<D> tClass = (Class<D>) ((ParameterizedType) getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];

    public Response<D> create(D domain){
        Session session = HibernateConfigurer.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(domain);
        session.getTransaction().commit();
        session.close();
        return new Response<>(domain);
    }
}
