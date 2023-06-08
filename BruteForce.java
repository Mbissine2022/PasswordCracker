import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class BruteForce {
    public String craquerSimple(String password) {
        String foundPassword;
        char[] chaine = new char[password.length()];
        System.out.println("craquage simple appelé");
        foundPassword = bruteForce(password, chaine, 0);
        if (foundPassword == null) {
            System.out.println("Bravo, nous n'avons pas pu craquer ton mot de passe !");
        } else {
            System.out.println("Ohh! Ton mot de passe est " + foundPassword);
        }
        return null;
    }

    public String bruteForce(String password, char[] chaine, int position) {
        if (position == password.length() - 1) {
            for (int i = 97; i < 97 + 26; i++) {
                chaine[position] = Character.toLowerCase((char) i);
                String combinaison = new String(chaine);
                System.out.println("La chaîne générée est : " + combinaison);
                if (password.equals(combinaison)) {
                    System.out.println("Ton mot de passe est : " + combinaison);
                    return combinaison;
                }
            }
            return null;
        } else {
            for (int i = 97; i < 97 + 26; i++) {
                chaine[position] = Character.toLowerCase((char) i);
                chaine = chaine.clone();
                if (bruteForce(password, chaine, position + 1) != null) {
                    return new String(chaine);
                }
            }
            return null;
        }
    }

    public String craquerHashed(String password) throws NoSuchAlgorithmException {
        String foundPassword;
        byte[] md = Hash(password);
        char[] chaine = new char[md.length];
        System.out.println("craquage haché appelé");
        foundPassword = bruteForceH(password, md, chaine, 0);
        if (foundPassword == null) {
            System.out.println("Bravo, nous n'avons pas pu cracker ton mot de passe !");
        } else {
            System.out.println("Ohh! Ton mot de passe est : " + foundPassword);
        }
        return null;
    }

    public String bruteForceH(String password, byte[] md, char[] chaine, int position) throws NoSuchAlgorithmException {
        if (position == password.length() - 1) {
            for (int i = 97; i < 97 + 26; i++) {
                chaine[position] = Character.toLowerCase((char) i);
                String combinaison = new String(chaine);
                byte[] test = Hash(combinaison);
                if (MessageDigest.isEqual(test, md)) {
                    System.out.println("Ton mot de passe est : " + combinaison);
                    return combinaison;
                }
            }
            return null;
        } else {
            for (int i = 97; i < 97 + 26; i++) {
                chaine[position] = Character.toLowerCase((char) i);
                chaine = chaine.clone();
                if (bruteForceH(password, md, chaine, position + 1) != null) {
                    return new String(chaine);
                }
            }
            return null;
        }
    }

    public byte[] Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        return messageDigest;
    }

    public static void main(String[] args) {
        BruteForce cracker = new BruteForce();
        try {
            String password = "asdf123";
            cracker.craquerSimple(password);

            String hashedPassword = cracker.encryptString(password);
            cracker.craquerHashed(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encryptString(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, messageDigest);
        return bigInt.toString(16);
    }
}
