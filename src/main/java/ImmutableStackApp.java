import ImLibrary.*;
import Stack.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ImmutableStackApp {

    //Using ImStack
    static ImStack<Track> stack = new ImStack<Track>(null, null);
    static ImStack<Track> tmpStack = new ImStack<Track>(null, null);

    private static Scanner option = new Scanner(System.in);

    static InputStreamReader converter = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(converter);

    private static Boolean run = true;

    public static void optLoop() throws StackException {
        while(run){
            try {
                Program();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public static void Program() throws StackException, IOException {

        int opt = 0;

        MenuOptions();

        try{
            opt = option.nextInt();
        } catch(InputMismatchException exception) {
            System.out.println("Sorry, input not recognised");
        }

        //TODO handle non-valid options better then just exiting
        while (run)
        {
            switch (opt){
                case 1:
                    // Enter a track
                    System.out.println("Enter artist name:");
                    String artist = input.readLine();

                    System.out.println("Enter track title:");
                    String title = input.readLine();

                    System.out.println("Enter track download count");
                    int downloadCount = option.nextInt();

                    stack = stack.push(new Track(artist, title, downloadCount));

                    Program();
                    break;

                case 2: // Print out stack
                    tmpStack = stack;
                    // Loop through nodes
                    while(tmpStack.iterator().hasNext()){
                        System.out.println(tmpStack.peek().toString());
                        tmpStack = tmpStack.iterator().next();
                    }

//                    for(int i = 0; i < stack.size(); i ++){
//                        Track v = tmpStack.peek();
//                        System.out.println(v.toString());
//                        // reduce stack
//                        tmpStack = tmpStack.pop();
//                    }

                    Program();
                    break;

                case 3: // Download increment

                    // Enter a track
                    String artist1;
                    System.out.println("Enter artist name:");
                    artist1 = input.readLine();

                    String title1;
                    System.out.println("Enter track title:");
                    title1 = input.readLine();

                    // new stack for amended
                    ImStack<Track> incStack = new ImStack<Track>(null, null);
                    ImStack<Track> tmpStack2;
                    // preserve the original stack
                    tmpStack2 = stack;
                    boolean found = false;

                    while(tmpStack2.iterator().hasNext()){
                        Track v = tmpStack2.peek();
                        if((v.getArtist().equals(artist1)) && (v.getTitle().equals(title1))){
                            // create a new track with same vals but inc count
                            Track incTrack = new Track(artist1, title1, v.getDownloadCount() + 1);
                            // push our new track to a incremental Stack counter
                            incStack = incStack.push(incTrack);
                            // notify user of increment
                            found = true;
                            System.out.println(incStack.peek().toString());
                            // remove this top item
                            tmpStack2 = tmpStack2.iterator().next();
                            // unfortunately even though we have found a match we need to preserve all the elements
                            // in the master stack so keep looping, example of inefficiency of stacks
                        }  else {
                            // shift the node to our incremental Stack counter
                            incStack = incStack.push(tmpStack2.peek());
                            // then remove it
                            tmpStack2 = tmpStack2.iterator().next();
                        }
                    }
                    if(!found) System.out.println("No match found in library");

//                    for(int i = 0; i < stack.size(); i ++){
//                        // get the top of stack
//                        Track v = tmpStack2.peek();
//                        // if top matches on artist and title
//                        if((v.getArtist().equals(artist1)) && (v.getTitle().equals(title1))){
//                            // create a new track with same vals but inc count
//                            Track incTrack = new Track(artist1, title1, v.getDownloadCount() + 1);
//                            // push our new track to a incremental Stack counter
//                            incStack = incStack.push(incTrack);
//                            // notify user of increment
//                            System.out.println(incStack.peek().toString());
//                            // remove this top item
//                            tmpStack2 = tmpStack2.pop();
//                        } else {
//                            // shift the node to our incremental Stack counter
//                            incStack = incStack.push(tmpStack2.peek());
//                            // then remove it
//                            tmpStack2 = tmpStack2.pop();
//                        }
//                    }

                    // as we want to keep a record of the change, assign the altered stack back to the original
                    stack = incStack;

                    Program();
                    break;


                case 4:  // List Top download count

                    tmpStack = stack;
                    // Create a new Stack
                    ImStack<Track> tempTop = new ImStack<Track>(new Track(null, null, 0), null);
                    // Loop through stack
                    while(tmpStack.iterator().hasNext()){
                        Track v = tmpStack.peek();
                        // if the download count is greater then the current largest then add it
                        if(v.getDownloadCount() > tempTop.peek().getDownloadCount()){
                            tempTop = tempTop.push(v);
                        }
                        tmpStack = tmpStack.iterator().next();
                    }

//                    for(int i = 0; i < stack.size(); i ++){
//                        Track v = tmpStack.peek();
//                        // if the download count is greater then the current largest then add it
//                        if(v.getDownloadCount() > tempTop.peek().getDownloadCount()){
//                            tempTop = tempTop.push(v);
//                        }
//                        tmpStack = tmpStack.pop();
//                    }

                    // Reveal our top track
                    if(tmpStack.isEmpty()){
                        System.out.println("Library is empty, add a track or run the import first");
                    } else {
                        System.out.println(tempTop.peek().toString());
                    }

                    Program();
                    break;

                case 5: // Artists top track

                    // Enter a track
                    String artist2;
                    System.out.println("Enter artist name:");
                    artist2 = input.readLine();

                    tmpStack = stack;
                    // temp stack for storing artist
                    ImStack<Track> tempArtistTop = new ImStack<Track>(null, null);
                    // loop through stack
                    while(tmpStack.iterator().hasNext()){
                        Track v = tmpStack.peek();
                        // if the artist match
                        if((v.getArtist().equals(artist2))){
                            // if the count is greater then last
                            if(v.getDownloadCount() > tempArtistTop.peek().getDownloadCount()){
                                tempArtistTop = tempArtistTop.push(v);
                            }
                        }
                        tmpStack = tmpStack.iterator().next();
                    }


//                    for(int i = 0; i < stack.size(); i ++){
//                        Track v = tmpStack.peek();
//                        // if the artist match
//                        if((v.getArtist().equals(artist2))){
//                            // if the count is greater then last
//                            if(v.getDownloadCount() > tempArtistTop.peek().getDownloadCount()){
//                                tempArtistTop = tempArtistTop.push(v);
//                            }
//                        }
//                        tmpStack = tmpStack.pop();
//                    }

                    if(tempArtistTop.isEmpty()){
                       System.out.println("No matching artists in library");
                    } else {
                        System.out.println(tempArtistTop.peek().toString());
                    }

                    Program();
                    break;

                case 9:
                    stack = new Import().ImStackData();
                    // Preserve master stack
                    tmpStack = stack;
                    // use iterator to loop through and print out our import
                    while(tmpStack.iterator().hasNext()){
                        System.out.println(tmpStack.peek().toString());
                        tmpStack = tmpStack.iterator().next();
                    }

                    Program();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Sorry, input not recognised");
                    opt = 0;
                    break;

            }
        }

    }

    public static void main(String[] args) throws StackException {
        optLoop();
    }

}
