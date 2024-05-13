package utility;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHAR_LOWER ="abcdefghijklmnopqstuvwxyz";
    private static final String CHAR_UPPER =CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHARACTERS = "@#$%&";
    private static final String RANDOM_PASSWORD = CHAR_LOWER + CHAR_UPPER + SPECIAL_CHARACTERS + NUMBER;

    private static final SecureRandom random = new SecureRandom();
    static StringBuilder stringBuilder =new StringBuilder(8);

    public static String generatePassword(){
        stringBuilder.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));
        stringBuilder.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));
        stringBuilder.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
        stringBuilder.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i=4;i<8 ;i++){
            stringBuilder.append(RANDOM_PASSWORD.charAt(random.nextInt(RANDOM_PASSWORD.length())));
        }
        return stringBuilder.toString();
    }
}
