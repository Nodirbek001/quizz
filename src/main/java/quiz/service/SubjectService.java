package quiz.service;


import quiz.dao.SubjectDAO;
import quiz.domain.subject.Subject;
import quiz.response.Response;

public class SubjectService implements Service<Subject>{
    private static SubjectService instance;

    @Override
    public Response<Subject> create(Subject domain) {
        try {
            return SubjectDAO.getInstance().create(domain);
        }catch (Exception e){
            return new Response<>(e.getMessage(), 101);
        }

    }

    @Override
    public Response<Subject> delete(Subject domain) {
        return null;
    }

    public static SubjectService getInstance() {
        if (instance==null) {
            instance=new SubjectService();
        }
        return instance;
    }
}
