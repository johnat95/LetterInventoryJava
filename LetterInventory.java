

public class LetterInventory {

    private final int ALPHABET_LENGTH = 26;

    private int[] countsArray = new int[ALPHABET_LENGTH];

    private int size;

    private String displayString;


    public LetterInventory(String string) {

        System.out.println("Processing: "+string);

        char[] charArray = string.toLowerCase().toCharArray();

        for (char c : charArray) {

            try {
                incrementCountArray(isLetter(c));
            }catch (IllegalArgumentException e){
                System.out.println("'"+c+"'"+ " rejected.");
            }
            //add letter value to inventory size
            updateSize(c);

        }
        generateDisplayString();
        System.out.println("Output: "+displayString);

    }

    public LetterInventory(int[] array) {

        this.countsArray = array;

        if(array != null){

            //uses array parameter to calculate size and
            //displayString of the new inventory
            for (int i = 0; i < ALPHABET_LENGTH;i++) {
                updateSize(array[i]*(i+1));
            }

            generateDisplayString();

        }else{
            System.out.println("Process Failed: Negative Counter");
        }

    }

    public LetterInventory add(LetterInventory other){

        int[] otherArray = other.getCountsArray();
        int[] newArray = new int[ALPHABET_LENGTH];

        for(int i = 0; i < ALPHABET_LENGTH; i++){

            //all the values at index i
            int newCount = this.countsArray[i] + otherArray[i];

            newArray[i] = newCount;
        }
        //return new LetterInventory constructed with newArray.
        return new LetterInventory(newArray);

    }


    public int[] getCountsArray(){
        return this.countsArray;
    }

    public LetterInventory subtract(LetterInventory other) throws Exception{


        int[] otherArray = other.getCountsArray();
        int[] newArray = new int[ALPHABET_LENGTH ];

        for(int i = 0; i < ALPHABET_LENGTH; i++){

            //all the values at index i
            int newCount = this.countsArray[i] - otherArray[i];

            if(newCount < 0){
                throw new Exception("ProcessFailed: negative counter");
            }else{
                newArray[i] = newCount;
            }

        }
        //return new LetterInventory constructed with newArray.
        return new LetterInventory(newArray);


    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void generateDisplayString(){
        StringBuilder stringBuilder = new StringBuilder();
        int charCount = 'a';

        //iterate though each letter
        for(int c : this.countsArray){

            //for each count, append that character to the string
            for(int j = 1; j <= c ;j++){
                stringBuilder.append((char)charCount);
            }
            charCount++;
        }
        this.displayString = stringBuilder.toString();
    }

    private int indexFromLetter(int letterValue){

        if(letterValue >= 'a' ){


           return letterValue-'a';
        }

        return -1;
    }


    private int isLetter(char letter) {

       if(letter >= 'a' && letter <= 'z'){

           //subtract the numerical value of the char 'a'
           //returns number equal to chars distance from 'a'
           return letter - 'a';
       }else {
           throw new IllegalArgumentException();
       }

    }

    private void incrementCountArray(int index){

        countsArray[index] = countsArray[index]+1;
    }

    @Override
    public String toString() {
        return displayString;
    }

    private void updateSize(int letterValue){
            size += letterValue;
    }
}
