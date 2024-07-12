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
  
