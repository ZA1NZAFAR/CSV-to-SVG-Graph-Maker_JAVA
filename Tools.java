import java.util.Random;

public class Tools {
    public static String getRandomRGB() {
        int a = new Random().nextInt(255);
        int b = new Random().nextInt(255);
        int c = new Random().nextInt(255);
        return "rgb(" + a + "," + b + "," + c + ")";
    }


}
