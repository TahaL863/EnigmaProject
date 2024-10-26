// Caeser Cipher
public class Checkpoint1{
  char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  

  public void Checkpoint1(){
    
    
  }
  public String encryptor(String text){
    text = text.toUpperCase();
    if (text.contains("!")){
      text = text.replace("!", "");
    }
    
    String output = "";
    for (int i = 0; i < text.length(); i++){
      if (text.charAt(i) == ' '){
        output += " ";
        
      }else if (((text.charAt(i)) + 1) > 122) {

        int temp = 97;

        char cati = (char) temp;

        output += cati;


       
      } else if (((text.charAt(i)) + 1) > 90 && ((text.charAt(i)) + 1) < 97) {

        int temp = 65;
        

        char cati = (char) temp;

        output += cati;



      }else{
        int temp = text.charAt(i)+1;
        char cati = (char) temp;
        output += cati;
      }
      
      
      
      
    }
    return output;
   // System.out.println(output);
    
  }
  public String decryptor(String text){
    String output = "";
    
    for (int i = 0; i < text.length(); i++){
      if (text.charAt(i) == ' '){
        output += " ";

      } else if (((text.charAt(i)) - 1) < 97 && ((text.charAt(i)) - 1) > 90) {
        


        int temp = 122;

        char cati = (char) temp;

        output += cati;



      } else if (((text.charAt(i)) - 1) < 65) {
        

        int temp = 90;
       

        char cati = (char) temp;

        output += cati;



      }else{
        int temp = text.charAt(i)-1;
        char cati = (char) temp;
        output += cati;
      }




    } 
    return output;
   // System.out.println(output);

  }
  public String advencryptor(String text, int combo){
    //System.out.println(combo);
    int combotemp1;
    int combotemp2;
    int combotemp3;
    text = text.toUpperCase();
    String output = "";
    if (text.contains("!")){
      text = text.replace("!", "");
    }
   
    /*if (text.contains("\"")){
      text = text.substring(text.indexOf("\"")+1, text.length()+1);


    } */
    
    for (int i = 0; i < text.length(); i++){
      //System.out.println(text.charAt(i)+combo);
      if (text.charAt(i) == ' '){
        output += " ";

      } else if (((text.charAt(i)) + combo) > 122) {
        
        //System.out.println("it gets here1");
        int temp = 97;
        combotemp1 = combo - (122 - (text.charAt(i)) + 1);
        temp += combotemp1;
        
        char cati = (char) temp;

        output += cati;
      

        
      } else if (((text.charAt(i)) + combo) > 90 && ((text.charAt(i)) + combo) <= 97) {
         

          int temp = 65;
         // System.out.println("it gets here2");
          combotemp2 = combo - (90 - (text.charAt(i)) + 1);
          temp += combotemp2;

          char cati = (char) temp;

          output += cati;


         
        } else{
        /*System.out.println("it gets here3");
        System.out.println(combo);
        System.out.println(text.charAt(i));*/
        
        

        int temp = (text.charAt(i))+combo;
        //System.out.println(temp);
        char cati = (char) temp;

        output += cati;
       
      } 




    }
    return output;
}
   public String advdecryptor(String text, int combo){
      text = text.toUpperCase();
      String output = "";
      for (int i = 0; i < text.length(); i++){
        if (text.charAt(i) == ' '){
          output += " ";

        } else if (((text.charAt(i)) - combo) < 97 && ((text.charAt(i)) - combo) > 90) {
          int lcombo = 0;
          

          int temp = 122;
          lcombo = combo - ( (text.charAt(i)) - 96);
          temp -= lcombo;

          char cati = (char) temp;

          output += cati;


          
        } else if (((text.charAt(i)) - combo) < 65 ){
          
          int locombo = 0;

            int temp = 90;
            locombo = combo - ((text.charAt(i)) - 65 + 1 );
            temp -= locombo;

            char cati = (char) temp;

            output += cati;



          } else{
           
          
          int temp = (text.charAt(i))-combo;
          char cati = (char) temp;

          output += cati;
        }




      }
      //output = output.toUpperCase();
      //System.out.println(output);
     
      return output;
  }
}