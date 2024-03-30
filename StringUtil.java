import java.security.MessageDigest;

public class StringUtil {
    // Aplica sha256 para a string e retorna o resultado
    public static String applySha256(String input) {
        try {
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // aplica o sha256 no input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            StringBuffer hexString = new StringBuffer(); // isso vai conter o hash como hexadecimal

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
