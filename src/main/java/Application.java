import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.Node;
import Library.*;

import DoubleLinkedList.List;
import DoubleLinkedList.InvalidPlaceException;
import RankingList.SortedRankingList;

import javax.swing.text.ElementIterator;
import java.io.IOException;
import java.lang.reflect.Method;
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

    public static void optLoop() throws InvalidPlaceException, EmptyListException {
        while(run){
            Program();
        }
    }

    public static void MenuOptions(){
        System.out.println("1 - Enter a new track");
        System.out.println("2 - List tracks");

        System.out.println("3 - List top plays");
        System.out.println("4 - List top downloads");

        System.out.println("5 - List Artists top track plays");
        System.out.println("6 - List Artists top track downloads");

        System.out.println("7 - Play a track");
        System.out.println("8 - Download track");

        System.out.println("9 - Import library");

        System.out.println("0 - EXIT");
    }

    public static void Program() throws InvalidPlaceException, EmptyListException {

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
                    t.setTrack(s1, s2).setTrackPlays(plays).setTrackDownloads(downloads);

                    rankingList.addFirst(t);

                    Program();
                    break;
                case 2:

                    System.out.println(rankingList.toString(rankingList));

                    Program();
                    break;
                case 3:

                    SortedRankingList sortedPlaysList = new Controller().mostPopular(rankingList, IPlays.class);

                    System.out.println(sortedPlaysList.toString(sortedPlaysList, "Plays"));
                    Program();

                case 4:

                    SortedRankingList sortedDownloadList = new Controller().mostPopular(rankingList, IDownloads.class);

                    System.out.println(sortedDownloadList.toString(sortedDownloadList, "Downloads"));
                    Program();

                    break;

                case 5:

                    SortedRankingList searchArtistPlays = new Controller().mostPopularTrackOf(input, rankingList, IPlays.class);

                    System.out.println(searchArtistPlays.toString(searchArtistPlays, "Plays"));
                    Program();
                    break;

                case 6:

                    SortedRankingList searchArtistDownloads = new Controller().mostPopularTrackOf(input, rankingList, IDownloads.class);
                    System.out.println(searchArtistDownloads.toString(searchArtistDownloads, "Downloads"));

                    Program();
                    break;

                case 7:
                    new Controller().incTrackOf(input, rankingList, IPlays.class);

                    Program();
                    break;

                case 8:

                    new Controller().incTrackOf(input, rankingList, IDownloads.class);

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

    public static void main(String[] args) throws IOException, InvalidPlaceException, EmptyListException {
        optLoop();
    }

}
