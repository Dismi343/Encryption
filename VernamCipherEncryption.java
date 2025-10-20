import java.util.*;

public class VernamCipherEncryption {

  
    public static void main(String[] args) {

        char[] alpha={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> keyList = new ArrayList<>();

        String plainText=scanner.nextLine().toUpperCase();
        StringBuilder cipherText=new StringBuilder();
        char[] plainArray=plainText.toCharArray();
        for(int i=0;i<plainArray.length;i++){
            for(int j=0;j<alpha.length;j++){
        
                    if(plainArray[i]==alpha[j]){
                        int randomIndex=random.nextInt(100);
                        int cipherIndex=(j+randomIndex)%26;
                        keyList.add(randomIndex);
                        System.out.println("Cipher Index: "+cipherIndex+" Random Index: "+randomIndex);
                        cipherText.append(alpha[cipherIndex]);
                        break;
                    }
            }
    }
    System.out.println("\nCipher Text: "+cipherText.toString());

    StringBuilder decryptedText = new StringBuilder();
    char[] cipherArray = cipherText.toString().toCharArray();
        
        for(int i=0; i<cipherArray.length; i++){
            for(int j=0; j<alpha.length; j++){
                if(cipherArray[i] == alpha[j]){
                    int originalIndex = Math.floorMod(j - keyList.get(i), 26);
                    decryptedText.append(alpha[originalIndex]);
                    break;
                }
            }
        }

    System.out.println("Decrypted Text: " + decryptedText.toString());
    
}
}


