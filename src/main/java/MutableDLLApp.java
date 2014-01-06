import DLList.*;
import Library.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MutableDLLApp {

    private static RankList sortList = new RankList();

    private static Scanner option = new Scanner(System.in);
    static InputStreamReader converter = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(converter);

    private static Boolean run = true;

    public static void optLoop() {
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

    public static void Program() throws IOException {

        int opt = 0;

        MenuOptions();

        try{
            opt = option.nextInt();
        } catch(InputMismatchException exception) {
            System.out.println("Sorry, option not recognised");
        }

        while (run)
        {
            switch (opt){
                case 1: // Enter a track

                    System.out.println("Enter artist name:");
                    String newArtist = input.readLine();

                    System.out.println("Enter track title:");
                    String newTitle = input.readLine();

                    System.out.println("Enter track starting download count");
                    int downloadCount = option.nextInt();

                    Track t = new Track().setTrack(newArtist, newTitle);

                    sortList.insert(downloadCount, t);

                    System.out.println(t.toString() + "- successfully added!");
                    Program();
                    break;

                case 2: // List all tracks

                    System.out.println(sortList.toString(sortList));

                    Program();
                    break;

                case 3: // Download count on a given Track

                    System.out.println("Enter artist name:");
                    String artist = input.readLine();

                    System.out.println("Enter track title:");
                    String title = input.readLine();

                    String search = artist + " - " + title;

                    Iterator it = sortList.iterator();
                    while(it.hasNext()){
                        Rank kv = (Rank) it.next();
                        if(kv.getVal().toString().equals(search)){
                            Integer k = (Integer) kv.getKey() + 1;
                            try {
                                sortList.replaceKey(kv, k);
                                break;
                            } catch (EmptyListException e) {
                                e.printStackTrace();
                            } catch (InvalidPlaceException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    Program();

                case 4:// List top download count

                    try {
                        System.out.println(sortList.max().toString());
                    } catch (EmptyListException e) {
                        e.printStackTrace();
                    } catch (InvalidPlaceException e) {
                        e.printStackTrace();
                    }
                    Program();
                    break;

                case 5:// List Artists top track download count

                    System.out.println("Enter artist name:");
                    artist = input.readLine();


                    Iterator it2 = sortList.iterator();
                    RankList artSortedList = new RankList();

                    while(it2.hasNext()){
                        Rank kv = (Rank) it2.next();
                        Track tr = (Track) kv.getVal();
                        if(tr.getArtist().equals(artist)){
                            artSortedList.insert(kv.getKey(), kv.getVal());
                        }
                    }
                    try {
                        System.out.println(artSortedList.max().toString());
                    } catch (EmptyListException e) {
                        System.out.println("List is empty");
                    } catch (InvalidPlaceException e) {
                        e.printStackTrace();
                    }
                    Program();
                    break;

                case 9:// Import all

                    try {
                        sortList = new Import().RandomData();
                    } catch (EmptyListException e) {
                        e.printStackTrace();
                    } catch (InvalidPlaceException e) {
                        e.printStackTrace();
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

    public static void main(String[] args) {
        optLoop();
    }

}
