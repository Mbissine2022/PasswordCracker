import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DictionaryCracker extends Cracker{
    public String craquerSimple(String password){

        // implémentation 
        try{
        File file = new File("french_passwords.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null){
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


        return null;
    }
}
