import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BruteForce extends Cracker {
    public String craquerSimple(String password){
        // implémentation 
        String foundPassword;
        char[] chaine = new char[password.length()];
        System.out.println("craquage simple appelé");
        foundPassword = bruteForce(password, chaine, 0);
        if(foundPassword == null ){
            System.out.println("Bravo nous n'avons pas pu craque ton mot de passe !");
        }else{
            System.out.println("Ohh! sa mot de passe baaxutt. sa mot de passe pi mooy "+foundPassword);
        }


        return null;
    }


    public String bruteForce(String password, char[] chaine, int position){
        
        if(position == password.length() - 1){
            // condition d'arret
             for(int i = 97; i< 97+26; i++){
                chaine[position] = (char)i;
                String combinaison = new String(chaine);
                System.out.println("la chaine genere est : "+combinaison);
                if(password.equals(combinaison)){
                    System.out.println("votre mot de pass est :  "+combinaison);
                    return combinaison;
                } 

            }
            return null;

        }else{
            // pas encore arrivé à la dernière lettre
            for(int i = 97; i< 97+26; i++){
                chaine[position] = (char)i;
                if(bruteForce(password, chaine, position+1)!= null){
                    return new String(chaine);
                }
                
            }
            return null;
        }
    }


    public String craquerHashed(String password){
        
        byte[] md = Hash(password);
        String foundPassword;
        char[] chaine = new char[md.length];
        System.out.println("craquer hache appelé");
        foundPassword = bruteForceH(password, md, chaine, 0);
        if(foundPassword == null ){
            System.out.println("Bravo nous n'avons pas pu cracke ton mot de passe !");
        }else{
            System.out.println("Ohh! sa mot de passe baaxutt. sa mot de passe pi mooy "+foundPassword);
        }


        return null;

    }

    public String bruteForceH(String password, byte[] md, char[] chaine, int position){
        
        if(position == password.length() - 1){
            // condition d'arret
             for(int i = 97; i< 97+26; i++){
                chaine[position] = (char)i;
                String combinaison = new String(chaine);
                byte[] test = Hash(combinaison);
                System.out.println("test : " + test);
                System.out.println("md :" +md);
        
                if(MessageDigest.isEqual(test,md)){
                    System.out.println("votre mot de passe est :  "+combinaison);
                    return combinaison;
                } 

            }
            return null;

        }else{
            // pas encore arrivé à la dernière lettre
            System.out.println("on est dans le else");
            for(int i = 97; i< 97+26; i++){
                chaine[position] = (char)i;
                if(bruteForceH(password, md, chaine, position+1)!= null){
                    return new String(chaine);
                }
                
            }
            return null;
        }
    }



        static byte[] Hash(String input){
            byte[] output=null;
          
                MessageDigest digest;
                try {
                    digest = MessageDigest.getInstance("SHA-1");
                    output = digest.digest(input.getBytes(StandardCharsets.UTF_8));
                } catch (NoSuchAlgorithmException e) {

                    e.printStackTrace();
                }
                
                return output;
        }


    }
