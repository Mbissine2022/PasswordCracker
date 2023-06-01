import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;



public class DictionaryCracker extends Cracker{
    public String craquerSimple(String password){

        // implémentation 
        try{
        File file = new File("french_passwords.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);

            if(line.equals(password)){
                //mot de passe trouve 
                bufferedReader.close();
                System.out.println("wooy loupe sa mot de passe baaxul. lii nga bind : "+line);
                return line;
            }
        }
        fileReader.close(); 
        System.out.println("Bravo sa mot de passe bii boulko change ");
        return null;
    } catch(Exception e){
        System.out.println("wouy loupe");
    }
        return password;
    }




    public String craquerHashed(String password){
        // implémentation 
 try{
        File file = new File("french_passwords.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        
        while((line = bufferedReader.readLine()) != null){
            byte[] test = Hash(line);
            byte[] psw = Hash(password);
            System.out.println(test);
            //System.out.println(line);

            //System.out.println(psw);
            if(MessageDigest.isEqual(test,psw)){
                //mot de passe trouve 
                bufferedReader.close();
                System.out.println("wooy loupe sa mot de passe baaxul. lii nga bind : "+line);
                return line;
            }
        }
        fileReader.close(); 
        System.out.println("Bravo sa mot de passe bii boulko change ");
        return null;
    } catch(Exception e){
        System.out.println("wouy loupe");
    }
        return password;

    }

    static byte[] Hash(String input){
        byte[] output=null;
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            output = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //return the byte array
        return output;
    }

}
