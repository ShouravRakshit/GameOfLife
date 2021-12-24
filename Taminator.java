/* As needed students can write additional methods and add attributes */
/*Name :- Shourav Rakshit Ivan
  UCID :- 30131085
  Tutorial :- 06

  Program Version:- 4/1/2021
*/
/* Program Features
  1. It taminates the adjacent cells. 
  2. It randomly teleports the taminator object.
*/
import java.util.Random;
public class Taminator extends Critter
{
    //Class attribute by James Tam. Students do not make any changes to it but
    //additional attributes may be added.
    public static final char DEFAULT_APPEARANCE = 'T';
    public Critter[][] taminator = new Critter[10][10];

    //Start of modifiable code written by James Tam
    //Taminator(), Taminator(char)
    //Students can make any changes.
    public Taminator()
    {
	super(DEFAULT_APPEARANCE);
    }

    public Taminator(char newAppearance)
    {
	super(newAppearance);
    }
    //End of modifiable code written by James Tam

    //Students can add additional methods below as needed.

    // Method for tamination
    public void tamination() {
        int rc;
        int cc;
        Random rand = new Random();
        int randRow;
        int randCol;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (taminator[i][j].getAppearance() == 'T') {
                    for (int j2 = i - 1; j2 <= i + 1; j2++) {
                        for (int k = j - 1; k <= j + 1; k++) {
                            rc = j2; // Checking for row
                            cc = k; // Checking for col
                            if ((j2 == i) && (k == j)) {
                                continue; // Condition for avoiding self cell
                            }

                            // Condition for not going out of bound.
                            if (j2 == -1) {
                                rc = 9;
                            }
                            if (j2 == 10) {
                                rc = 0;
                            }
                            if (k == -1) {
                                cc = 9;
                            }
                            if (k == 10) {
                                cc = 0;
                            }

                            if (taminator[rc][cc].getAppearance() == '*') { // taminating the neighbour.
                                if (taminator[rc][cc] == null) {
                                    taminator[rc][cc] = new Critter();
                                }
                                taminator[rc][cc].setAppearance(' ');
                            }

                        }
                    }

                    // teliportation remains.
                    while (true) {
                        randRow = rand.nextInt(10);
                        randCol = rand.nextInt(10);
                        if ((taminator[randRow][randCol].getAppearance() == ' ') && (randRow != i)) {
                            if (taminator[randRow][randCol] == null) {
                                taminator[randRow][randCol] = new Critter();
                            }
                            taminator[randRow][randCol].setAppearance('T');
                            break;
                        }
                }
                taminator[i][j].setAppearance(' ');
                break;

               
              }  

            }

        }
    }
    
    }


    









