package quiz.dao;


import quiz.domain.subject.Subject;

public class SubjectDAO extends GenericDAO<Subject>{
    private static SubjectDAO instance;

    public static SubjectDAO getInstance() {
        if (instance==null) {
            instance = new SubjectDAO();
        }
        return instance;
    }
}