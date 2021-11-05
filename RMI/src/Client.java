import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class Client{
    private String email;
    private String password;
    private static String fileHeader = "email,password";

    public Client(String email, String hash){
        this.email = email;
        this.password = hash;
    };

    public static String hashPassword(String password)
    {
        byte[] salt = "https://www.youtube.com/watch?v=dQw4w9WgXcQ".getBytes(StandardCharsets.UTF_8);

        try{
            MessageDigest md = MessageDigest.getInstance("sha-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedPassword);
        }catch(Exception exception)
        {
            System.out.println(exception);
            return null;
        }
    }

    public String getEmail()
    {
        return this.email;
    }

    public boolean authenticate(String plainPassword)
    {
        return this.password.equals(hashPassword(plainPassword));
    }

    public static String getFileHeader()
    {
        return fileHeader;
    }

    @Override
    public String toString() {
        return email + "," + password;
    }
}