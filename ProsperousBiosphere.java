/* As needed students can write additional methods and add attributes */
/*Name :- Shourav Rakshit Ivan
  UCID :- 30131085
  Tutorial :- 06

  Program Version:- 4/1/2021
  */

/* Program Features 
1. It overloads all biosphere.
2. It adjusts new Birth and Death rule by passing new value.
*/

public class ProsperousBiosphere extends Biosphere // Students can't change this inheritance relation.
{
    Taminator object = new Taminator();
    

    //Students can make any changes except for the relationship.
    public ProsperousBiosphere(Critter [][] aWorld)
    {
        super(aWorld);
    }
    
    
   
    public void startP() {
        runTurn(object,4,1);
    }

}

