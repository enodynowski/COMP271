import java.util.Scanner;
public class PigLatin {
    public static void main (String[] args) throws StringIndexOutOfBoundsException{
        String sentence = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence to translate:");
        sentence = input.nextLine();
        

        if (sentence.equals("")){
            System.exit(0);

        } else {
            while (!sentence.equals("")){
                System.out.println(translateSentence(sentence));
                System.out.print("Enter a sentence to translate:");
                sentence = input.nextLine();
            }
        }
        input.close();
    }
    public static String translateSentence(String sentence){
        String[] words = sentence.split(" ");
        String translatedSentence = "";
        for(int i = 0; i < words.length; i++){
            translatedSentence += translateOneWord(words[i]) + " ";
        }
        return translatedSentence;
    }


    public static String translateOneWord(String word){
        
        if (startsWithVowel(word)){
            return word + "-ay";
        }
        else if (startsWithConsonantCombo(word)){
            return word.substring(2) + "-" + word.substring(0,2) + "ay";
        } else if (word.length() == 2 ){ 
            return "-" + word + "ay";
        } else {
            return word.substring(1) + "-" + word.charAt(0) + "ay";
        }
    }


    public static boolean startsWithVowel(String word){
        String vowels = "aeiouAEIOU"; 
        return (vowels.indexOf(word.charAt(0)) != -1);
    }

    public static boolean startsWithConsonantCombo(String word){
        String[] combos = {"bl", "br", "ch", "cl", "cr", "dr", "dw", "fl", "fr", "gl", "gr", "kl", "ph", "pl", "pr", "qu", "sc", "kn", "sk", "sl", "sm", "sn", "sp", "sq", "st", "sw", "th", "tr", "tw", "wh", "wr"};
        boolean startsWithCombo = false;
        for(int i = 0; i < combos.length; i++){
            if(word.startsWith(combos[i])){
                startsWithCombo = true;
            } else {
                continue;
            }
        }
        return startsWithCombo;
    }
}
