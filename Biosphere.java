/* As needed students can write additional methods and add attributes */
import java.util.Scanner;

 /*Name :- Shourav Rakshit Ivan
  UCID :- 30131085
  Tutorial :- 06

  Program Version:- 4/1/2021
  */

/* Program Features 
1. It displays the whole board side by side.
2. It checks the surrounding of the cell.
3. Birth and Death for Biosphere world.
*/




public class Biosphere
{
    //Constant declarations and attributes by James Tam, don't change.
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final String HORIZONTAL_LINE = "  - - - - - - - - - -";
    public static final String HORIZONTAL_COUNT = "  0 1 2 3 4 5 6 7 8 9 ";
    private Critter [][] current; 
    Critter[][] birthDeath = new Critter[10][10];
    Critter [][] previousStage = new Critter[10][10];
    Taminator obj = new Taminator();
    String dash = "  ";
    int lowerLimit = 2;
    int upperLimit = 3;

    //Original code written by James Tam, don't modify
    public Biosphere(Critter [][] aWorld)
    {
        //Original code
        current = aWorld;

        //Student code
        
    }

   

    //Original code written by James Tam, don't modify
    public Critter [][] getCurrent() 
    {
        return(current);
    }

    // The code used by the student was based on the display code written by James Tam

    public void display(Critter [][] change) {
        // Original code below: student can freely modify to fulfill assignment
        // requirements
        // (add, delete, change existing code).
        int i;
        int r;
        int c;
        System.out.println("  PREVIOUS GENERATION" + dash + "    BIRTHS & DEATHS    "+ dash + "  TAMINATOR");
        System.out.println(HORIZONTAL_COUNT + dash + HORIZONTAL_COUNT + dash + HORIZONTAL_COUNT);
        System.out.print(" ");
        for (i = 0; i < ROWS; i++)
            System.out.print(" -");  // Line of dashes before the array1
            System.out.print(dash+"  ");

        for (i = 0; i < ROWS; i++)
            System.out.print(" -"); // Line of dashes before the array2
        System.out.print(dash + "  ");

        for (i = 0; i < ROWS; i++)
            System.out.print(" -"); // Line of dashes before the array3
        System.out.println();
        for (r = 0; r < ROWS; r++) {
            System.out.print(r); // Line # before each row
            for (c = 0; c < COLUMNS; c++) {
                System.out.print("|" + current[r][c]); // Bounding line left of array1 element
            }
            
            System.out.print("|"+ dash); // Bounding line at the of the row for the last element of array1

            System.out.print(r); // Line # before each row
            for (c = 0; c < COLUMNS; c++) {
                System.out.print("|" + birthDeath[r][c]); // Bounding line left of array2 element
            }

            System.out.print("|" + dash); // Bounding line at the of the row for the last element of array2

            System.out.print(r); // Line # before each row
            for (c = 0; c < COLUMNS; c++) {
                System.out.print("|" + change[r][c]); // Bounding line left of array3 element
            }

            System.out.println("|"); // Bounding line at the of the row for the last element of array3
            System.out.print(" ");

            for (i = 0; i < ROWS; i++)
                System.out.print(" -"); // Bounding line below each array1 element
                System.out.print(dash + "  ");

            for (i = 0; i < ROWS; i++)
                System.out.print(" -"); // Bounding line below each array2 element
                System.out.print(dash + "  ");

            for (i = 0; i < ROWS; i++)
                System.out.print(" -"); // Bounding line below each array3 element
                System.out.println();
            
        }
    }

    // Method for converting Critter to characters
    public void cricToChar() {
        for (int i = 0; i < birthDeath.length; i++) {
            for (int j = 0; j < birthDeath.length; j++) {
                previousStage[i][j] = new Critter(current[i][j].getAppearance());  

            }
        }
    }

    

    // Method for copying array.
    public void arrayCopy(Critter [][] source, Critter [][] target) {
        for (int i = 0; i < birthDeath.length; i++) {
            for (int j = 0; j < birthDeath.length; j++) {
                if (target[i][j] == null) {
                    target[i][j] = new Critter();
                }
                if(source[i][j]== null){
                    source[i][j] = new Critter(' ');
                }
                target[i][j].setAppearance(source[i][j].getAppearance());

            }
        }
    }

    //Original code written by James Tam
    // Checking the condition for quit the game.
    public void runTurn(Taminator change1, int a, int b)
    {
        //Original code below: student can freely modify to fulfill assignment requirements
        //(add, delete, change existing code).
        Scanner scanner = new Scanner(System.in);
        String choice;
        cricToChar();

        checkingSurround(a,b);

        arrayCopy(birthDeath, change1.taminator); // Copying birthDeath to taminator

        change1.tamination(); // Work for tamination
        display(change1.taminator);
        
        arrayCopy(change1.taminator, previousStage); // Updating the board.  

        while(true){
        System.out.print("Press Enter to continue : ");
        choice = scanner.nextLine();
        if (choice.toLowerCase().equals("q")) {
            System.out.println("The Game is over.");
            break;
        }
        checkingSurround(a,b);

        arrayCopy(birthDeath, change1.taminator); // Copying birthDeath to taminator

        change1.tamination(); // Work for tamination
        display(change1.taminator);        
        arrayCopy(change1.taminator, previousStage); // Updating the board.

    }
    scanner.close();
    }

    public void start() {
        runTurn(obj,3,2);
    }

    // Method for Checking the surrounding of the cell.
    public void checkingSurround(int a, int b) {
        int count;
        int rc;
        int cc;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {    

                count = 0;
                for (int j2 = i-1; j2 <= i+1; j2++) {
                    for (int k = j-1; k <= j+1; k++) {
                        rc = j2;                        
                        cc = k;                         
                        if ((j2 == i) && (k == j)) {
                            continue;                   // Condition for avoiding self cell
                        }

                    // Condition for not going out of bound.
                    if (j2 == -1){
                        rc = 9;
                    }      
                    if (j2 == 10){
                        rc = 0;
                    }
                    if (k == -1){
                        cc = 9;
                    }
                    if (k == 10){
                        cc = 0;
                    }

                    if (previousStage[rc][cc].getAppearance()=='*') {             // neighbour checking
                        count++;
                    }

                    }
                }

                if (previousStage [i][j].getAppearance() != 'T') {
                    
                        createBD(count, i, j,a,b);      //a=3, b= 2.
                    
                }  
                else{
                    if (birthDeath[i][j] == null) {
                        birthDeath[i][j] = new Critter();
                    }
                    birthDeath[i][j].setAppearance(previousStage[i][j].getAppearance()); 
                }
                    
                
            }

        }
    }
    
    // Method for Birth and Death in the cells.

    public void createBD(int a, int row, int col,int upperLimit,int lowerLimit) {
        if (a == upperLimit) {
            if (birthDeath[row][col] == null) {
                birthDeath[row][col] = new Critter('*');
            }
            birthDeath[row][col].setAppearance('*');         
        }
        
        if ((a < lowerLimit) || (a > upperLimit)) {
            if (birthDeath[row][col] == null) {
                birthDeath[row][col] = new Critter(' ');
            }
            birthDeath[row][col].setAppearance(' ');
        }

        if ((a >= lowerLimit) && (a < upperLimit)) {
            if (birthDeath[row][col] == null) {
                birthDeath[row][col] = new Critter();
            }
            birthDeath[row][col].setAppearance(previousStage[row][col].getAppearance());    
        }
    }

   
}
