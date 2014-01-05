package ImLibrary;

import Stack.*;

/**
 * User: stefancross
 * Date: 20/12/2013
 * Time: 18:50
 */
public class Import {

    private static ImStack<Track> imStack = new ImStack<Track>(null, null);
    private static Stack<Track> mutableStack = new Stack<Track>();


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

    public Stack StackData() {

        mutableStack.push(new Track("a", "a", 1));
        mutableStack.push(new Track("a", "b", 10));
        mutableStack.push(new Track("a", "c", 99));
        mutableStack.push(new Track("b", "a", 12));
        mutableStack.push(new Track("b", "b", 31));
        mutableStack.push(new Track("c", "a", 121));
        mutableStack.push(new Track("d", "a", 1921));

        return mutableStack;
    }
}



