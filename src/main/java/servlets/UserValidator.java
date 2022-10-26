package servlets;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserValidator {
    private static final int MAX_LENGTH_USERNAME = 25;
    private static final int MAX_LENGTH_EMAIL = 30;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final int MIN_LENGTH_PASSWORD = 8;
    private static final int MAX_LENGTH_PASSWORD = 30;


    public static boolean isValid(String username, String email, String country, String date, String sex, String password) {
        if (checkIfNull(username, email, country, date, sex, password)) {
            return false;
        }
        return isAnyBlank(username, email, password, country) && checkUsername(username) && checkEmail(email) && checkPassword(password);
    }

    private static boolean checkIfNull(Object... arr) {
        return Arrays.stream(arr).anyMatch(Objects::isNull);
    }

    private static boolean isAnyBlank(String... arr) {
        return Arrays.stream(arr).anyMatch(String::isBlank);
    }

    private static boolean checkUsername(String username) {
        return username.length() < MAX_LENGTH_USERNAME;
    }

    private static boolean checkPassword(String password) {
        return password.length() < MAX_LENGTH_PASSWORD && password.length() > MIN_LENGTH_PASSWORD;
    }

    private static boolean checkEmail(String email) {
        return email.length() < MAX_LENGTH_EMAIL && EMAIL_PATTERN.matcher(email).find();
    }


}
