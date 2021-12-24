import java.util.Scanner;

/* No additional methods and nor attributes to be added. */ 

/*
  Name:- Shourav Rakshit Ivan
  UCID:- 30131085
  Tutorial:- 06
*/

/* Program Features
   1. Acts as simple simulator of Game of life 
   2. Provides opportunity for modifying rules to play regular biosphere or prosperous biosphere.
*/
/*
    Program version:- 1/04/2021
*/

public class GameOfLife
{
    public static void main (String [] args)
    {
        String letter  = " ";
        Scanner scanner = new Scanner(System.in);
        Critter[][] temporary = new Critter[10][10];
        
        //Start of code written by James Tam, students can freely modify (but still need to 
        //fulfill assignment requirements and stylistic approaches).
        Biosphere regular;
        ProsperousBiosphere prosper;
        temporary = FileInitialization.read();
        System.out.println("Press P or p for ProsperousBiosphere or r or R for regular Biosphere");
        letter = scanner.nextLine().toLowerCase();
        if (letter.equals("p")) {
            prosper = new ProsperousBiosphere(temporary);
            prosper.startP();

        } else if(letter.equals("r")) {
            regular = new Biosphere(temporary);
            regular.start();

        }  
        else{
            System.out.println("Invalid choice");
        }
        scanner.close();
    }
}



