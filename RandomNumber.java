import java.util.concurrent.TimeUnit;

/**
 * Created by bedaa on 04/03/2017.
 */
public class RandomNumber {
    public int Random(){
        return (int )(Math.random() * 37);
    }

    public void delay(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
