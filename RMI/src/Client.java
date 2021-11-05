import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.UUID;

public class Client{
    private String id;
    private String email;
    private String password;

    public Client(String clientId, String email, String plainPassword){
        this.email = email;
        this.password = hashPassword(plainPassword);
        this.id = UUID.randomUUID().toString();
    };

    private String hashPassword(String password)
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return new String(hashedPassword, StandardCharsets.UTF_8);
        }catch(Exception exception)
        {
            System.out.println(exception);
            return null;
        }
    }

    public int getId()
    {
        return this.id;
    }

    public String getEmail()
    {
        return this.email;
    }

    public boolean isPassword(String plainPassword)
    {
        return this.password == hashPassword(plainPassword);
    }
}