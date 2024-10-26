// Affine Cipher with offset
import java.util.*;
public class Checkpoint3 extends Checkpoint2{
  

  char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  

  public void checkpoint3(){
    
    
  }
  public String encryptor(String affine, String word ){
    String out = super.encryptor(affine, word);
    return out;
    
    
    
  }
  public String decryptor(String affine, String word ){
    String out = super.decryptor(affine, word);
    return out;



  }
  public String offsetencryptor(String affine, String word, char offset ){
   int offset2 = (int)offset - 65;
   //System.out.println(offset2);
   char[] affinear = affine.toCharArray();
   int[] ascifine = new int[affinear.length];
   char[] affinear2 = new char[affinear.length];
   String affinear3 = "";
   String og2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   char[] og2ar = og2.toCharArray();
   int[] asciog2 = new int[og2ar.length];
   char[] og3ar = new char[og2ar.length];
   String og3 = "";

    for (int i = 0; i < og2ar.length; i++){
      if (((int)og2ar[i]) - offset2 < 65){
        asciog2[i] = 90  - (offset2 - ((int)og2ar[i] - 65 + 1)); 
      } else {
        asciog2[i] = ((int)og2ar[i]) - offset2;
      }
      
       
     }
      for (int i = 0; i < asciog2.length; i++){
         og3ar[i] = (char)asciog2[i];
       }

      for (int i = 0; i < og3ar.length; i++){
        og3 += og3ar[i];
      }
    
   
   for (int i = 0; i < affinear.length; i++){
     if (((int)affinear[i]) - offset2 < 65){
       ascifine[i] = 90  - (offset2 - ((int)affinear[i] - 65 + 1)); 
       
     } else{
       ascifine[i] = ((int)affinear[i]) - offset2;
     }
     
   }
    for (int i = 0; i < ascifine.length; i++){
       affinear2[i] = (char)ascifine[i];
     }

    for (int i = 0; i < affinear2.length; i++){
      affinear3 += affinear2[i];
    }
    
    
    
    
    
    
  /*  System.out.println(Arrays.toString(affinear)); 
   System.out.println(Arrays.toString(ascifine)); 
    System.out.println(Arrays.toString(affinear2)); 
     System.out.println(affinear3);
    System.out.println(og3); */
    
   String out = super.specencryptor(affinear3, word, og3);
   return out;
    



  }
  public String offsetdecryptor(String affine, String word, char offset ){
   int offset2 = (int)offset - 65;
   //System.out.println(offset2);
   char[] affinear = affine.toCharArray();
   int[] ascifine = new int[affinear.length];
   char[] affinear2 = new char[affinear.length];
   String affinear3 = "";
   String og2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   char[] og2ar = og2.toCharArray();
   int[] asciog2 = new int[og2ar.length];
   char[] og3ar = new char[og2ar.length];
   String og3 = "";

    for (int i = 0; i < og2ar.length; i++){
      if (((int)og2ar[i]) - offset2 < 65){
        asciog2[i] = 90  - (offset2 - ((int)og2ar[i] - 65 + 1)); 
      } else {
        asciog2[i] = ((int)og2ar[i]) - offset2;
      }


     }
      for (int i = 0; i < asciog2.length; i++){
         og3ar[i] = (char)asciog2[i];
       }

      for (int i = 0; i < og3ar.length; i++){
        og3 += og3ar[i];
      }


   for (int i = 0; i < affinear.length; i++){
     if (((int)affinear[i]) - offset2 < 65){
       ascifine[i] = 90  - (offset2 - ((int)affinear[i] - 65 + 1)); 

     } else{
       ascifine[i] = ((int)affinear[i]) - offset2;
     }

   }
    for (int i = 0; i < ascifine.length; i++){
       affinear2[i] = (char)ascifine[i];
     }

    for (int i = 0; i < affinear2.length; i++){
      affinear3 += affinear2[i];
    }






  /* System.out.println(Arrays.toString(affinear)); 
   System.out.println(Arrays.toString(ascifine)); 
    System.out.println(Arrays.toString(affinear2)); 
     System.out.println(affinear3);
    System.out.println(og3); */

   String out = super.specdecryptor(affinear3, word, og3);
   return out;




  }




  
  

}