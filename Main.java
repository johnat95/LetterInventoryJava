public class Main {

    public static void main(String[] args) {

        //runs demo showing LetterInventory methods
        Thread demoThread = new Thread(new Demo());

        demoThread.start();

    }
}
