package ImLibrary;

import Stack.*;

public class Import {

    private static ImStack imStack = new ImStack(null, null);


    public Import(){

    }

    public ImStack ImStackData() {

        imStack = imStack.push(new Track("a", "a", 1));
        imStack = imStack.push(new Track("a", "b", 10));
        imStack = imStack.push(new Track("a", "c", 99));
        imStack = imStack.push(new Track("b", "a", 12));
        imStack = imStack.push(new Track("b", "b", 31));
        imStack = imStack.push(new Track("c", "a", 121));
        imStack = imStack.push(new Track("d", "a", 1921));

        return imStack;
    }

}



