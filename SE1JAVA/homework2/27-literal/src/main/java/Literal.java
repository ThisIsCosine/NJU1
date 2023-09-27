import java.util.Scanner;
public class Literal {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String str = input.next();
       char[] charArray = str.toCharArray();
       if (charArray[0] == '\''){
           System.out.println("char");
       } else{
           if (charArray[charArray.length - 1] == 'L'){
               System.out.println("long");
           } else if (charArray[charArray.length - 1] == 'f') {
               System.out.println("float");
           } else if (str.equals("true") || str.equals("false")) {
               System.out.println("boolean");
           } else {
               for (int i = 0; i < str.length(); i++){
                   if (charArray[i] == '.'){
                       System.out.println("double");
                       break;
                   }
                   if (i == str.length() - 1){
                       System.out.println("integer");
                   }
               }
           }
       }
        //TODO
    }
}
