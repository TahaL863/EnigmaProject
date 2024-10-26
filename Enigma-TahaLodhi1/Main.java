// Taha Lodhi
// Period 2
// Enigma Project
import java.util.*;

// https://www.101computing.net/enigma-machine-emulator/
// Checkpoint #1 commands:
//   >C text
//   <C text
//   >C8 text
//   <C8 text
//
// Checkpoint #2 commands:
//   >A text
//   <A text
//   amap = CBDFEGHKJILMNOPQRSTUVWXYZA   // the affine map
//
// Checkpoint #3 commands:
//   >R text  // encrypt text using Rotor I only, 1-way, toward reflector
//   <R text  // decrpyt text using Rotor I only, 1-way, toward plugboard
//   >RC text // encrypt text, Rotor I, with an offset of C
//   <RK test // decrypt text, Rotor I, with an offset of K
//
// Checkpoint #4 commands:
//   >E text     // encrypt 1-way, toward reflector, using Rotors I,II,III. No offset.
//   <E text     // encrypt 1-way, toward plugboard, using Rotors I,II,III. No offset.
//   >EABC text  // encrypt 1-way, toward reflector, using Rotors I,II,III. offset = A B C
//   <EABC text  // encrypt 1-way, toward plugboard, using Rotors I,II,III. offset = A B C
//
//   rotors = II II I
//   offset = N D O
//   plugboard = AZ BY CX DW EV FU GT HS IR JQ
//
//  if command has no '='', and does not start with '>' or '<' 
//     then just use Enigma Machine to encrypt/decrypt
//
//   BARRELROLL    // encrpt the text using settings
//   RQGMLJZFCE    // encrpt the text using settings
//   Hello World   // Will also removes spaces. converts to upper case.
//   Hello, World  // removes punctuation, too.
//
// Finally, if there are two sections of text, assume one is plain text and the other
// is Enigma Text. The goal is to crack the machine and identify the rotors, offsets and plugboard.
//   VIMQUICKBROWNFOXESJUMPEDOVERTHELAZYDOG = QHYVRDMEIDSCMKCJNUFBYRPFADZSGROMGDZGBX

public class Main {
    String amap = "";
    String result = "";

    public static Scanner console = new Scanner(System.in);
   
    public static void main(String[] args) {
        Main program = new Main();
        program.runInputLoop();
    }

    public String processCommand(String command) {
        String encmap = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        String rotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";  
        String rotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        String rotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ  ";


        
        String result = "";
        if ((command.charAt(1) == 'C') || (command.charAt(1) == 'c') ){
            Checkpoint1 obj = new Checkpoint1();
            if (command.charAt(0) == '>' && !command.substring(2,3).matches("[0-9]")){
              result = obj.encryptor(command.substring(3));
            } else if (command.charAt(0) == '<' && !command.substring(2,3).matches("[0-9]")){
                result = obj.decryptor(command.substring(3));
            
            } else if ((command.charAt(0) == '>') && (command.substring(2,3).matches("[0-9]")) && (!command.substring(3,4).matches("[0-9]")) ){
                result = obj.advencryptor(command.substring(4), Integer.parseInt(command.substring(2,3)));
         } else if ((command.charAt(0) == '<') && (command.substring(2,3).matches("[0-9]")) &&(!command.substring(3,4).matches("[0-9]"))){
                    result = obj.advdecryptor(command.substring(4), Integer.parseInt(command.substring(2,3)));
             }else if ((command.charAt(0) == '>') && (command.substring(2,4).matches("[0-9][0-9]"))){
                    result = obj.advencryptor(command.substring(5), Integer.parseInt(command.substring(2,4)));
             }else if ((command.charAt(0) == '<') && command.substring(2,4).matches("[0-9][0-9]")){
                    result = obj.advdecryptor(command.substring(5), Integer.parseInt(command.substring(2,4)));
             }
        
    }
        if (command.charAt(0) == 'a'){
        
            amap = command.substring(7);
       
        
        
        }    
        if (command.charAt(1) == 'A'){
            Checkpoint2 obj2 = new Checkpoint2();
            if (command.charAt(0) == '>'){
            result = obj2.encryptor(amap, command.substring(3));
            }
            else if (command.charAt(0) == '<'){
                result = obj2.decryptor(amap, command.substring(3));
            }
        }
        if (command.charAt(1) == 'R'){
            Checkpoint3 obj3 = new Checkpoint3();
        
        
            if(!command.substring(2,3).matches("[A-Z]")){
                if (command.charAt(0) == '>'){
                    
                    result = obj3.encryptor(encmap, command.substring(3));
                
                }
                if (command.charAt(0) == '<'){

                    result = obj3.decryptor(encmap, command.substring(3));

                }
            
            
            }
            if(command.substring(2,3).matches("[A-Z]")){
                if (command.charAt(0) == '>'){

                    result = obj3.offsetencryptor(encmap, command.substring(4), command.charAt(2));

                }
                if (command.charAt(0) == '<'){

                    result = obj3.offsetdecryptor(encmap, command.substring(4), command.charAt(2));

                }
                


            }
            
        }
        if (command.charAt(1) == 'E'){
            Checkpoint4 obj4 = new Checkpoint4();
            String temp = "";
            if (command.charAt(0) == '>' && !command.substring(2,3).matches("[A-Z]") ){
                temp = obj4.offsetencryptor(rotor3, command.substring(3), 'A');
                System.out.println(temp);
                temp = obj4.offsetencryptor(rotor2, temp, 'A');
                System.out.println(temp);
                temp = obj4.offsetencryptor(rotor1, temp, 'A');
                result = temp;

            }
            if (command.charAt(0) == '<' && !command.substring(2,3).matches("[A-Z]")){
                
                temp = obj4.offsetdecryptor(rotor1, command.substring(3), 'A');
            
                temp = obj4.offsetdecryptor(rotor2, temp, 'A');
               
                temp = obj4.offsetdecryptor(rotor3, temp, 'A');
                result = temp;

            }
            if (command.charAt(0) == '>' && command.substring(2,3).matches("[A-Z]") ){
                temp = obj4.offsetencryptor(rotor3, command.substring(6), command.charAt(4));
               
                temp = obj4.offsetencryptor(rotor2, temp, command.charAt(3));
               
                temp = obj4.offsetencryptor(rotor1, temp, command.charAt(2));
                result = temp;

            }
            if (command.charAt(0) == '<' && command.substring(2,3).matches("[A-Z]") ){
                temp = obj4.offsetdecryptor(rotor1, command.substring(6), command.charAt(2));
               
                temp = obj4.offsetdecryptor(rotor2, temp, command.charAt(3));
                
                temp = obj4.offsetdecryptor(rotor3, temp, command.charAt(4));
                result = temp;

            }
            
            
            



        }   
            return result;
        }
   

    private void runInputLoop() {
        boolean done = false;
        while (!done) {
            System.out.print("Enter: ");
            String input = console.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("quit")) {
                done = true;
            } else if (input.length() > 0 && !UnitTestRunner.processCommand(input, this::processCommand)) {
                String result = processCommand(input);
                System.out.println(result);
            }
        }
    }
}