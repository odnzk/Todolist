package validators;

import model.User;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {
    private static final int MAX_LENGTH_USERNAME = 25;
    private static final int MAX_LENGTH_EMAIL = 30;
    private static final String USERNAME_REGEX = "^[A-Za-z]\\w{5, 29}$";
    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final int MIN_LENGTH_PASSWORD = 8;
    private static final int MAX_LENGTH_PASSWORD = 30;

    private boolean checkIfNull(Object... arr) {
        return Arrays.stream(arr).anyMatch(Objects::isNull);
    }

    private boolean isAnyBlank(String... arr) {
        return Arrays.stream(arr).anyMatch(String::isBlank);
    }

    private boolean checkUsername(String username) {
        return username.length() < MAX_LENGTH_USERNAME && matcher(USERNAME_REGEX, username);
    }

    private boolean checkPassword(String password) {
        return password.length() < MAX_LENGTH_PASSWORD && password.length() > MIN_LENGTH_PASSWORD;
    }

    private boolean checkEmail(String email) {
        return email.length() < MAX_LENGTH_EMAIL && matcher(EMAIL_REGEX, email);
    }

    private boolean matcher(String regex, String body) {
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(body).find();
    }

    @Override
    public boolean validate(User user) {
        if (checkIfNull(user.getUsername(), user.getEmail(), user.getPassword())) {
            return false;
        }
        return true;
//        return isAnyBlank(user.getPassword(), user.getEmail(), user.getUsername())
//                && checkUsername(user.getUsername())
//                && checkEmail(user.getEmail())
//                && checkPassword(user.getPassword());
    }

}
