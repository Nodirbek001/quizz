package quiz.ui;

import quiz.dao.SubjectDAO;
import quiz.domain.subject.Subject;
import quiz.domain.user.Login;
import quiz.domain.user.User;
import quiz.response.Response;
import quiz.service.UserService;
import quiz.session.Session;
import quiz.util.Reader;
import quiz.util.Util;


import java.util.List;

import static quiz.domain.user.User.Role.ADMIN;

public class UI {
    public static void main() {
        while (true) {
            switch (Util.menu(List.of("QUIZ BOT", "0. Exit", "1. Sign in",
                    "2. Sign up", "3. Reset password"))) {
                case "0" -> {
                    return;
                }
                case "1"->signIn();
                case "2" -> signUp();
            }
        }
    }

    private static void signIn() {
        Response<User> response = UserService.getInstance().signIn(Login.builder()
                .username(Reader.readLine("Username: "))
                .password(Reader.readLine("Password: "))
                .build());
        if(response.isSuccess()){
            Session.getInstance().user = response.getData();
            System.out.println(response.getData());
            if (response.getData().getRole() == ADMIN) {
                adminPage();
            }
        }else {
            System.out.println(response.getErrorMessage());
        }
    }

    private static void adminPage() {
        while (true){
            switch (Util.menu(List.of("USER PAGE", "0. Exit", "1. Subject CRUD",
                    "2. Question CRUD", "3. Profile CRUD"))){
                case "0"->{return;}
                case "1"->subjectCRUD();
                case "2"->{}
            }
        }
    }

    private static void subjectCRUD() {
        while (true){
            switch (Util.menu(List.of("SUBJECT", "0. Exit", "1. Create", "2. Show all",
                    "3. Show certain", "4. Update", "Delete"))){
                case "0"->{return;}
                case "1"->subjectCreate();
            }
        }
    }

    private static void subjectCreate() {
        Response<Subject> response = SubjectDAO.getInstance().create(Subject.builder()
                .name(Reader.readLine("Subject name: "))
                .build());
        if (response.isSuccess()) {
            System.out.println(response.getData());
        }else {
            System.out.println(response.getErrorMessage());
        }
    }

    private static void signUp() {
        Response<User> response = UserService.getInstance().create(User.builder()
                .login(Login.builder()
                        .username(Reader.readLine("Username: "))
                        .password(Reader.readLine("Password: "))
                        .email(Reader.readLine("Email: "))
                        .build())
                .build());
        if(response.isSuccess()){
            System.out.println(response.getData());
        }else {
            System.out.println(response.getErrorMessage());
        }
    }
}
