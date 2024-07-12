  
//   Problem:

// In a computer security course, you just learned about password decryption. Your fellow student has created their own password encryption method, and they’ve asked you to test how secure it is. Your task is to recover the original password given the encrypted password provided to you by your classmate.

// At first, it seems impossible. But one day after class, you catch a peek of your classmates notebook where the encryption process is noted. You snap a quick picture of it to reference later. It says this:

// Given string s, let s[i] represent the ith character in the string s, using O-based indexing.

// Assumptions are:
// Initially i = 0.
// If s[i] is lowercase and the next character s[i+1] is uppercase, swap them, add a ‘*’ after them, and move to i+2.
// If s[i] is a number, replace it with o, place the original number at the start, and move to i+1.
// Else, move to i+1.
// Stop if its more than or equal to the string length. Otherwise, go to step 2.
// There’s even an example mentioned in the notebook. When encrypted, the string “hAck3rR4nK” becomes “34Ah*ck0rR0Kn”. (Note: the original string, “hAck3rR4nK”, does not contain the character 0.)

// Note:

// The original string always contains digits from 1 to 9 and does not contain 0.
// The original string always contains only alpha-numeric characters.
// Using this information, your task is to determine the original password (before encryption) when given the encrypted password from your classmate.

// Function Description
// Complete the function decryptPassword. decryptPassword must return the original password string before it was encrypted by your classmate.

// decryptPassword has the following parameter: S: the password string after it was encrypted by your classmate.

// Constraints
// 1 ≤ length of s ≤ 105
// scan contain Latin alphabet characters (a-z, A-Z), numbers (0–9), and the character ‘*’.
import java.util.ArrayList;
class arr{

  public static String decryptPassword(String s) {
    // Write your code here
    ArrayList<Character> str = new ArrayList<>();
    ArrayList<Character> lett = new ArrayList<>();  
      for(int i=0;i<s.length();i++){
          if(Character.isDigit(s.charAt(i)) && s.charAt(i)!='0'){//got the numbers
              str.add(s.charAt(i));
          }
      }
      int j=0;
      for(int i=0;i<s.length()-1;i++){
       if(Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(s.charAt(i+1))){
        lett.add(s.charAt(i+1));
        lett.add(s.charAt(i));
           i+=2;
       }
       else if(Character.isLowerCase(s.charAt(i)) && Character.isLowerCase(s.charAt(i))){
        lett.add(s.charAt(i));
        lett.add(s.charAt(i+1));
        i+=1;
       }
       else if(s.charAt(i)=='0'){
        lett.add(str.get(str.size()-(++j)));
       } 
      }
      lett.add(s.charAt(s.length()-1));
      StringBuilder stringBuilder = new StringBuilder(lett.size());
      for (int i = 0; i < lett.size(); i++) {
        stringBuilder.append(lett.get(i));
      }
      return stringBuilder.toString();
    }
    public static void main(String[] args) {
      
      System.out.println(decryptPassword("51Pa*0Lp*0e"));
    }
    }
  
