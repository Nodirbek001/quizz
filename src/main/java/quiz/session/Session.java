package quiz.session;


import quiz.domain.user.User;

public class Session {
    private static Session instance;

    public User user;

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
}
