import ImLibrary.*;
import Stack.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImmutableStackApp {

    //Using ImStack
    static ImStack<Track> stack = new ImStack<Track>(null, null);
    static ImStack<Track> tmpStack = new ImStack<Track>(null, null);

    private static Scanner input = new Scanner(System.in);
    private static Boolean run = true;

    public static void optLoop() throws StackException {
        while(run){
            Program();
        }
    }

    public static void MenuOptions(){
        System.out.println("1 - Enter a new track");

        System.out.println("2 - List tracks");

        System.out.println("3 - Download track");

        System.out.println("4 - List top download count");

        System.out.println("5 - List Artists top track download count");

        System.out.println("9 - Import library");

        System.out.println("0 - EXIT");
    }

    public static void Program() throws StackException {

        int opt = 0;

        MenuOptions();

        try{
            opt = input.nextInt();
        } catch(InputMismatchException exception) {
            System.out.println("Sorry, option not recognised");
        }

        //TODO handle non-valid options better then just exiting
        while (run)
        {
            switch (opt){
                case 1:
                    // Enter a track
                    String artist;
                    System.out.println("Enter artist name:");
                    artist = input.next();

                    String title;
                    System.out.println("Enter track title:");
                    title = input.next();

                    int downloadCount;
                    System.out.println("Enter track download count");
                    downloadCount = input.nextInt();

                    Track t = new Track(artist, title, downloadCount);

                    stack = stack.push(t);

                    Program();
                    break;

                case 2: // Print out stack
                    tmpStack = stack;
                    // Loop through nodes
                    for(int i = 0; i < stack.size(); i ++){
                        Track v = tmpStack.peek();
                        System.out.println(v.toString());
                        // reduce stack
                        tmpStack = tmpStack.pop();
                    }

                    Program();
                    break;

                case 3: // Download increment

                    // Enter a track
                    String artist1;
                    System.out.println("Enter artist name:");
                    artist1 = input.next();

                    String title1;
                    System.out.println("Enter track title:");
                    title1 = input.next();

                    // new stack for amended
                    ImStack<Track> incStack = new ImStack<Track>(null, null);
                    ImStack<Track> tmpStack2;
                    // preserve the original stack
                    tmpStack2 = stack;

                    for(int i = 0; i < stack.size(); i ++){
                        // get the top of stack
                        Track v = tmpStack2.peek();
                        // if top matches on artist and title
                        if((v.getArtist().equals(artist1)) && (v.getTitle().equals(title1))){
                            // create a new track with same vals but inc count
                            Track incTrack = new Track(artist1, title1, v.getDownloadCount() + 1);
                            // push our new track to a incremental Stack counter
                            incStack = incStack.push(incTrack);
                            // notify user of increment
                            System.out.println(incStack.peek().toString());
                            // remove this top item
                            tmpStack2 = tmpStack2.pop();
                        } else {
                            // shift the node to our incremental Stack counter
                            incStack = incStack.push(tmpStack2.peek());
                            // then remove it
                            tmpStack2 = tmpStack2.pop();
                        }
                    }
                    // as we want to keep a record of the change, assign the altered stack back to the original
                    stack = incStack;

                    Program();
                    break;


                case 4:  // List Top download count

                    tmpStack = stack;
                    // Create a new Stack
                    ImStack<Track> tempTop = new ImStack<Track>(new Track("end", "end", 0), null);
                    // Loop through stack
                    for(int i = 0; i < stack.size(); i ++){
                        Track v = tmpStack.peek();
                        // if the download count is greater then the current largest then add it
                        if(v.getDownloadCount() > tempTop.peek().getDownloadCount()){
                            tempTop = tempTop.push(v);
                        }
                        tmpStack = tmpStack.pop();
                    }

                    // Reveal our top track
                    System.out.println(tempTop.peek().toString());

                    Program();
                    break;

                case 5: // Artists top track

                    // Enter a track
                    String artist2;
                    System.out.println("Enter artist name:");
                    artist2 = input.next();

                    tmpStack = stack;
                    // temp stack for storing artist
                    ImStack<Track> tempArtistTop = new ImStack<Track>(new Track("end", "end", 0), null);
                    // loop through stack
                    for(int i = 0; i < stack.size(); i ++){
                        Track v = tmpStack.peek();
                        // if the artist match
                        if((v.getArtist().equals(artist2))){
                            // if the count is greater then last
                            if(v.getDownloadCount() > tempArtistTop.peek().getDownloadCount()){
                                tempArtistTop = tempArtistTop.push(v);
                            }
                        }
                        tmpStack = tmpStack.pop();
                    }

                    System.out.println(tempArtistTop.peek().toString());
                    Program();
                    break;

                case 9:
                    stack = new Import().ImStackData();

                    if(stack.iterator().hasNext()){
                        Track t12 = stack.iterator().next();
                    }

                    Program();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Sorry, option not recognised");
                    opt = 0;
                    break;

            }
        }

    }

    public static void main(String[] args) throws StackException {
        optLoop();
    }

}
