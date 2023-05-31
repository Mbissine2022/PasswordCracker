public class PasswordCrackerFactory {
    public void CrackPassword(String password, char[] chaine){

        
    }

    public static Cracker getCracker(String type){
        if(type.equals("bruteforce")){
            return new BruteForce();
        }else{
            return new DictionaryCracker();
        }
    }    
}

            // public class PasswordCracker {
            //         String password = "password123"; // Mot de passe à cracker
            //         String[] dictionary = { "password", "123456", "qwerty", "admin" };
                    
            //         for (String word : dictionary) {
            //             if (word.equals(password)) {
            //                 System.out.println("Mot de passe trouvé : " + word);
            //                 break;
            //             }
            //         }
            // }}
            
    