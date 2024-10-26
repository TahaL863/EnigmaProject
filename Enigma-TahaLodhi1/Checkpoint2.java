// Affine Cipher
public class Checkpoint2{
  char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  

  public void checkpoint2(){
    
    
  }
  public String encryptor(String affine, String word ){
    word = word.toUpperCase();
    String out = "";
    String og = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for (int i = 0; i < word.length(); i++){
    if (word.substring(i, i+1).equals(" ")){
      i++;
      out+= " ";
    }
  
    String temp1 = word.substring(i, i+1);
    int temp2 = og.indexOf(temp1);
    String temp3 = affine.substring(temp2, temp2+1);
    //System.out.println(temp3);
    out += temp3;
  }
    return out;
  }
  public String decryptor(String affine, String word ){
    word = word.toUpperCase();
    String out = "";
    String og = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for (int i = 0; i < word.length(); i++){
    if (word.substring(i, i+1).equals(" ")){
      i++;
      out+= " ";
    }

    String temp1 = word.substring(i, i+1);
    int temp2 = affine.indexOf(temp1);
    String temp3 = og.substring(temp2, temp2+1);
    
    out += temp3;
  }
    return out;
  }
  public String specencryptor(String affine, String word, String og ){
    word = word.toUpperCase();
    String out = "";
    
  for (int i = 0; i < word.length(); i++){
    if (word.substring(i, i+1).equals(" ")){
      i++;
      out+= " ";
    }

    String temp1 = word.substring(i, i+1);
    int temp2 = og.indexOf(temp1);
    String temp3 = affine.substring(temp2, temp2+1);
    //System.out.println(temp3);
    out += temp3;
  }
    return out;
  }
  public String specdecryptor(String affine, String word, String og ){
    word = word.toUpperCase();
    String out = "";
    
  for (int i = 0; i < word.length(); i++){
    if (word.substring(i, i+1).equals(" ")){
      i++;
      out+= " ";
    }

    String temp1 = word.substring(i, i+1);
    int temp2 = affine.indexOf(temp1);
    String temp3 = og.substring(temp2, temp2+1);

    out += temp3;
  }
    return out;
  }
  
  



}