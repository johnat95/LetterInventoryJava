public class Demo implements Runnable {

    @Override
    public void run() {
        //initialize LetterInventories
        LetterInventory a = new LetterInventory("Isaac Newton1");
        System.out.println("a inventory: " + a.toString() + " Empty: "+ a.isEmpty());

        LetterInventory b = new LetterInventory("Michael Faraday%");
        System.out.println("b inventory: " + b.toString());

        //test exception handling
        System.out.print("a - b: ");
        LetterInventory e;
        try {
            e = a.subtract(b);
            System.out.println("a - b: "+ e.toString());
        }catch (Exception ex){
            System.out.println(ex);
        }

        //add b + b
        LetterInventory c = b.add(b);
        System.out.println("b + b: "+ c.toString());

        //subtract b from c
        LetterInventory d;
        try {
            d = c.subtract(b);
            System.out.println("c - b: "+ d.toString());
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
