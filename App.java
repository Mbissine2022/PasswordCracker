import java.io.FileNotFoundException;
import java.util.Scanner;

public class App{
    public static void main(String[] argc) throws FileNotFoundException{
        
        Scanner scanner = new Scanner(System.in);
        String choix;
        int module;

        System.out.println("Bienvenu dans notre application !");
        System.out.println("1-------> Pour casser un mot de passe simple !");
        System.out.println("2-------> Pour casser un mot de passe hashé !");
        module = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Veuillez choisir votre méthode : \nbruteforce ou dictionary");
        choix = scanner.nextLine();

        System.out.println("Veuillez ecrire votre mot de passe \n");
        String password = scanner.nextLine();
        Cracker cracker = PasswordCrackerFactory.getCracker(choix);

        if(module==1){
            // module craquer mot de passe simple
            cracker.craquerSimple(password);
       } else{
            // module craquer mot de passe hashé
            cracker.craquerHashed(password);
       }
     


       






        scanner.close();


        
    }
}