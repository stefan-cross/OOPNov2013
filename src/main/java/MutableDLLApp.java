import DLList.*;
import Library.*;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MutableDLLApp {

    private static RankList sortList = new RankList();
    static Controller controller = new Controller();
    private static Scanner input = new Scanner(System.in);
    private static Boolean run = true;

    public static void optLoop() {
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

    public static void Program() {

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
                    String newArtist;
                    System.out.println("Enter artist name:");
                    newArtist = input.next();

                    String newTitle;
                    System.out.println("Enter track title:");
                    newTitle = input.next();

                    int downloadCount;
                    System.out.println("Enter track starting download count");
                    downloadCount = input.nextInt();

                    Track t = new Track().setTrack(newArtist, newTitle);

                    try {
                        sortList.insert(downloadCount, t);
                    } catch (EmptyListException e) {
                        e.printStackTrace();
                    } catch (InvalidPlaceException e) {
                        e.printStackTrace();
                    }

                    System.out.println(t.toString() + "- successfully added!");
                    Program();
                    break;
                case 2:
                    // List all tracks
                    System.out.println(sortList.toString(sortList));

                    Program();
                    break;
                case 3:
                    // Download count on a given Track
                    String b1;
                    System.out.println("Enter artist name:");
                    b1 = input.next();

                    String b2;
                    System.out.println("Enter track title:");
                    b2 = input.next();

                    String b3 = b1 + " - " + b2;

                    Iterator it = sortList.iterator();
                    while(it.hasNext()){
                        Rank kv = (Rank) it.next();
                        if(kv.getVal().toString().equals(b3)){
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

                case 4:
                    // List top download count
                    try {
                        System.out.println(sortList.max().toString());
                    } catch (EmptyListException e) {
                        e.printStackTrace();
                    } catch (InvalidPlaceException e) {
                        e.printStackTrace();
                    }
                    Program();
                    break;

                case 5:
                    // List Artists top track download count
                    String c1;
                    System.out.println("Enter artist name:");
                    c1 = input.next();


                    Iterator it2 = sortList.iterator();
                    RankList artSortedList = new RankList();

                    while(it2.hasNext()){
                        Rank kv = (Rank) it2.next();
                        Track tr = (Track) kv.getVal();
                        if(tr.getArtist().equals(c1)){
                            try {
                                artSortedList.insert(kv.getKey(), kv.getVal());
                            } catch (EmptyListException e) {
                                System.out.println("List is empty");
                            } catch (InvalidPlaceException e) {
                                e.printStackTrace();
                            }
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

                case 9:
                    // Import all
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
