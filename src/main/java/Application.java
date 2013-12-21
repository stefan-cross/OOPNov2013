import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.Node;
import Library.Import;
import Library.MusicLibrary;
import Library.Track;

import DoubleLinkedList.List;
import DoubleLinkedList.InvalidPlaceException;
import RankingList.SortedRankingList;

import javax.swing.text.ElementIterator;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */
public class Application {


    // Uses stacks
    private static MusicLibrary lib = new MusicLibrary();

    // Using lists
    private static List rankingList = new List();

    private static Scanner input = new Scanner(System.in);
    private static Boolean run = true;

    public static void optLoop() throws InvalidPlaceException {
        while(run){
            Program();
        }
    }

    public static void MenuOptions(){
        System.out.println("1 - Enter a new track");
        System.out.println("2 - List tracks");

        System.out.println("3 - List top plays");
        System.out.println("4 - List top downloads");

        System.out.println("5 - List Artists top tracks");
        System.out.println("6 - List Artists top downloads");

        System.out.println("7 - Play a track");
        System.out.println("8 - Download track");

        System.out.println("9 - Import library");

        System.out.println("0 - EXIT");
    }

    public static void Program() throws InvalidPlaceException {

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
                    String s1;
                    System.out.println("Enter artist name:");
                    s1 = input.next();

                    String s2;
                    System.out.println("Enter track title:");
                    s2 = input.next();

                    int plays;
                    System.out.println("Enter track plays");
                    plays = input.nextInt();

                    int downloads;
                    System.out.println("Enter track downloads");
                    downloads = input.nextInt();

                    Track t = new Track();
                    t.setTrack(s1, s2);
                    t.setPlays(plays);
                    t.setDownloads(downloads);


                    // Our new cool list
                    rankingList.addFirst(t);

                    // Old stack method
                    //lib.add(t);

                    Program();
                    break;
                case 2:
                    // Old stack method
//                    try {
//                        lib.printList();
//                    } catch (ListException e) {
//                        e.printStackTrace();
//                    }

                    // New List with Iterator
                    System.out.println(rankingList.toString(rankingList));



                    Program();
                    break;
                case 3:




                    // List plays ranking;
                    //TODO, move into Music Library class and keep the app to interaction logic only
                    SortedRankingList sortedPlaysList = new SortedRankingList();
                    Iterator elIt = rankingList.iterator();

                    while(elIt.hasNext()){
                        try {
                            // Consider the use of casting here
                            Track test = (Track) elIt.next();
                            sortedPlaysList.insert(test.getPlays(), test.getTitle());

                        } catch (EmptyListException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(sortedPlaysList.toString(sortedPlaysList));


                    Program();
                case 4:
                    SortedRankingList sortedDownloadList = new SortedRankingList();
                    Iterator dlIt = rankingList.iterator();

                    while(dlIt.hasNext()){
                        try {
                            Track downloadsTrack = (Track) dlIt.next();
                            sortedDownloadList.insert(downloadsTrack.getDownloads(), downloadsTrack.getTitle());
                        } catch (EmptyListException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(sortedDownloadList.toString(sortedDownloadList));


                    break;

                case 5:
                    System.out.println("Please enter the artist:");
                    String search = input.next();

                    SortedRankingList searchRankingList = new SortedRankingList();
                    Iterator searchIt = rankingList.iterator();

                    while(searchIt.hasNext()){
                        Track searchingTrack = (Track) searchIt.next();
                        if(searchingTrack.getName().equals(search)){
                            try {
                                searchRankingList.insert(searchingTrack.getPlays(), searchingTrack.getTitle());
                            } catch (EmptyListException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println(searchRankingList.toString(searchRankingList));
                    Program();
                    break;

                case 9:
                    rankingList = new Import().RandomData();
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

    public static void main(String[] args) throws IOException, InvalidPlaceException {
        optLoop();
    }

}
