
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class encrypt{
    public static void main(String[] args){

        System.out.println("Enter text");
        Scanner scanner=new Scanner(System.in);
         String x=scanner.nextLine();


        try{
            KeyGenerator keygenerator
                = KeyGenerator.getInstance("DES");

            SecretKey myDesk= keygenerator.generateKey();

            Cipher desCipher= Cipher.getInstance("DES");

            byte[] text=x.getBytes("UTF8");

            desCipher.init(Cipher.ENCRYPT_MODE,myDesk);
            byte[] textEncrypted= desCipher.doFinal(text);

            String s=new String(textEncrypted);
            System.out.println(s);


             desCipher.init(Cipher.DECRYPT_MODE, myDesk);
            byte[] textDecrypted= desCipher.doFinal(textEncrypted);

            // Converting decrypted byte array to string
            s = new String(textDecrypted);
            System.out.println(s);

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }
}