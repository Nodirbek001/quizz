package quiz.service;


import quiz.dao.UserDAO;
import quiz.domain.user.Login;
import quiz.domain.user.User;
import quiz.response.Response;

public class UserService implements Service<User> {


    private static UserService instance;

    @Override
    public Response<User> create(User domain) {
        try {
            return UserDAO.getInstance().create(domain);
        } catch (Exception e) {
            return new Response<>(e.getMessage(), 101);
        }
    }

    @Override
    public Response<User> delete(User domain) {
        return null;
    }

    public Response<User> signIn(Login login) {
        try {
            Response<User> response = UserDAO.getInstance().getByUsername(login.getUsername());
            if (response.getData().getLogin().getPassword().equals(login.getPassword())) {
                return new Response<>(response.getData());
            }
        } catch (Exception e) {
            return new Response<>(e.getMessage(), 101);
        }
        return new Response<>("Something wrong", 101);
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
}
