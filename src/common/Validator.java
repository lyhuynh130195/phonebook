package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String PHONE_REGEX = "^[0][0-9]{9}";
    public static final String EMAIL_REGEX = "[A-Z a-z][a-z A-Z 0-9]+@[A-Z a-z]+[.]com";
    public static final String BIRTHDAY_REGEX = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)[0-9]{2})$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void isPhoneNumber(String numberPhone) throws NumberPhoneException {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(numberPhone);
        boolean flag = matcher.matches();
        if (!flag) {
            throw new NumberPhoneException();
        }
    }

    public static void isBirthDay(String birthDay) throws BirthDayException {
        pattern = Pattern.compile(BIRTHDAY_REGEX);
        matcher = pattern.matcher(birthDay);
        boolean flag = matcher.matches();
        if (!flag) {
            throw new BirthDayException();
        }

    }

    public static void isEmail(String email) throws EmailException {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        if (!flag) {
            throw new EmailException();
        }
    }
}
