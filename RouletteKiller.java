import java.util.Scanner;

//Roulette Rules: max bet 100$, min bet 1$
//Our tactic : we wait until 100 spins without a null.
//Ideal : 3000

/**
 * Created by bedaa on 04/03/2017.
 */
public class RouletteKiller {

    public static void main( String[] args){

    RandomNumber random = new RandomNumber();

    Scanner k = new Scanner(System.in);
    //we set the starting budget
    System.out.print("Please set the starting budget: ");
    int budget = k.nextInt();
    int startingbudget = budget;



    int ourbets = 1;
    int result;
    int loss = 0;
    int spin = 0;
    int loosingset = 0;
    int bets = 0;
    int spinswithoutbet = 0;
    int doubledthemony = 0;

        // on the beginning we wait until we get 100 zeros
        while (loosingset < 100 ) {
            random.delay(0);
            //we spin without betting
            result = random.Random();
            spin++;
            spinswithoutbet++;
            System.out.println("-----------------------");
            if (result != 0) {
                loosingset++;

                System.out.println("This was the " + spin + ". spin.");
                System.out.println("The result : " + result);
                System.out.println("This was the " + loosingset + ". spin without a zero and without betting.");
                if(loosingset != 100) {
                    System.out.println("We only start after 100. spin without zero.");
                }
                else {
                    System.out.println("We can start betting with 1$.");

                }
            }
            else{
                loosingset = 0;
                System.out.println("This was the " + spin + ". spin.");
                System.out.println("The result : " + result);
                System.out.println("Shit, it's a zero, we have to start over.");
            }
            System.out.println("-----------------------");

        }

        loosingset = 0;
    while ( budget > 0 ){
        random.delay(0); //



        System.out.println("-----------------------");
        //we place a bet
        bets++;
        budget = budget - ourbets;
        loss = loss + ourbets;
        //roulette spins
        spin++;
        result = random.Random();


        System.out.println("This was the " + spin + ". spin.");
        System.out.println("This was our " + bets + ". bet.");
        System.out.println("The result : " + result);

        // if the result is 0 we win --- we start with 1$ again
        if (result == 0) {
            System.out.println("We won " + ourbets * 36 + "$.");
            budget = budget + ourbets * 36;
            ourbets = 1;
            loss = 0;
            loosingset = 0;
            System.out.println("Current balance: " + budget);
            System.out.println("Now we have to wait for a set without 100 zeros.");
            //if we double the money
            if (startingbudget * 2 <= budget){
                System.out.println("You have doubled your starting budget.");
                System.out.println("No you have " + budget +  "$, and you started with + " + startingbudget + "$.");
                System.out.print("The program countinues in a few seconds");
                random.delay(10);
                doubledthemony++;
                startingbudget = budget;
            }

            //we wait until we get 100 zeros
            while (loosingset < 100 ) {
                random.delay(0);
                //we spin without betting
                result = random.Random();
                spin++;
                spinswithoutbet++;
                System.out.println("-----------------------");
                if (result != 0) {
                    loosingset++;

                    System.out.println("This was the " + spin + ". spin.");
                    System.out.println("The result : " + result);
                    System.out.println("This was the " + loosingset + ". spin without a zero and without betting.");
                    System.out.println("We only start after 100. spin without zero.");
                }
                else{
                    loosingset = 0;
                    System.out.println("This was the " + spin + ". spin.");
                    System.out.println("The result : " + result);
                    System.out.println("Shit, it's a zero, we have to start over.");
                }
                System.out.println("-----------------------");

            }

        }

        //if the result is not 0 we have to bet again
        else {
            loosingset++;
            //if the loss is bigger than the amount we can win we have to increase our bet
            System.out.println("We didn't win.");
            System.out.println("Current balance: " + budget);
            System.out.println("Current loss: " + loss);
            System.out.println("This was the " + loosingset + ". bet without winning");
            //when do we have to increase our stake?
            if( loss >= ourbets * 35){
                System.out.println("We have to bet again.");
                System.out.println("We have already made a loss of " + loss +
                        "$, and with a " + (ourbets) + " bet we would only make a profit of " +
                        ((ourbets) * 35 + ", which means no profit. "));
                    ourbets++;
                    System.out.println("We have to bet with " + ourbets + "$");

                 if(ourbets > 100){
                    System.out.println("Problem is we are not allowed to bet with " + ourbets
          + " $ chips. Maximum is 100$");
                    ourbets = 100;
                }
            }

            else{
                System.out.println("We have to bet again with a " + ourbets + " chip.");
            }

        }
        //if we have less man than we should bet we place all in
        if (budget < ourbets && budget != 0) {
            System.out.println("We only have " + budget + " left. ALL IN.");
            ourbets = budget;
        }
        else if(budget == 0 ){
            System.out.println("We have no more money to bet");
            budget = -1;
        }





        System.out.println("-----------------------");
        }
        System.out.println("We lost after " + spin + " spins.");

        System.out.println("We had to spin " + spinswithoutbet + " times without a bet.");
        System.out.println("Meaning, that we bet " + (spin - spinswithoutbet) + " times.");
        System.out.println("We have doubled our money " + doubledthemony + " times.");
    }



}

