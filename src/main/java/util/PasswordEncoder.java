package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    private final String salt = "[4f1serf9";

    public String encode(String password) {
        String generatedPassword;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            md.update(this.salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
        return generatedPassword;
    }
}
