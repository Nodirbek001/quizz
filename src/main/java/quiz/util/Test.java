package quiz.util;

import quiz.dao.SubjectDAO;
import quiz.dao.UserDAO;
import quiz.ui.UI;

public class Test {
    public static void main(String[] args) {

//        SubjectDAO.getInstance().deleteSubject(1);
        SubjectDAO.getInstance().getSubject().getData().forEach(System.out::println);

    }
}
