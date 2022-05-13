//Programmer: Nathan Johnston
//Date: 5/12/2022
//Class: CS145
//

//This class contains methods to create instances of the LetterInventory, to add and subtract
//inventories, keep tract of size and to display the contents of the inventory.

public class LetterInventory {

    private final int ALPHABET_LENGTH = 26;

    private int[] countsArray = new int[ALPHABET_LENGTH];

    private int size;

    private String displayString;

    //This constructor takes a string, converts it to lower case and
    // creates a char[] from it. The array is then iterated through
    // and each character counted each time it occurs, and its value
    //is added to the size property.
    public LetterInventory(String string) {

        System.out.println("Processing: "+string);

        char[] charArray = string.toLowerCase().toCharArray();

        for (char c : charArray) {

            try {
                //if the letter passes checks in isLetter
                //the counter at the matching index will be incremented
                incrementCountArray(indexFromLetter(c));
            }catch (IllegalArgumentException e){
                System.out.println("'"+c+"'"+ " rejected.");
            }
            //add letter value to inventory size
            size++;

        }
        generateDisplayString();
        System.out.println("Output: "+displayString);

    }
    //This constructor calculates the size of the inventory by iterating
    // through the array, adding the valyue to the size property and appending
    // the letter corresponding to the index for as many times as it occurs
    // with a StringBuilder. The result of the string builder toString()
    // method is then returned.
    public LetterInventory(int[] array) {

        this.countsArray = array;

        if(array != null){

            //uses array parameter to calculate size and
            //displayString of the new inventory
            for (int i = 0; i < ALPHABET_LENGTH;i++) {
                size += array[i];
            }

            generateDisplayString();

        }else{
            System.out.println("Process Failed: Negative Counter");
        }

    }
    //Adds the count values at each index and fills a new countArray with the results,
    // returns a new instance of LetterInventory constructed with the new array
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

    public int getSize(){
        return size;
    }

    //_This method subtracts the count values of the LetterInventory passed to it
    // and returns a new LetterInventory. If any of the counters are negative after
    // subtraction this method returns null
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
    // returns true if size is zero
    public boolean isEmpty(){
        return size == 0;
    }
    //This method initializes the displayString property with
    //the characters int the counts array
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

    //this method returns the index of the counts array corresponding to the letter passed to it.
    private int indexFromLetter(char letter) {

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

    //Returns the displayString property of the LetterInventory class
    @Override
    public String toString() {
        return displayString;
    }

}
