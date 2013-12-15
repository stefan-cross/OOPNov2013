import Library.MusicLibrary;
import Library.Track;

import RankingList.RankingList;
import RankingList.InvalidPlaceException;

import RankingStack.ListException;

import java.io.IOException;
import java.util.InputMismatchException;
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
    private static RankingList rankingList = new RankingList();

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
        System.out.println("8 - Play a track");
        System.out.println("9 - Download track");
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

                    Track t = new Track();
                    t.setTrack(s1, s2);


                    try {
                        rankingList.addElement(t);
                    } catch (InvalidPlaceException e) {
                        e.printStackTrace();
                    }


                    // Old stack method
                    //lib.add(t);
                    Program();
                    break;
                case 2:
                    try {
                        lib.printList();
                    } catch (ListException e) {
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

    public static void main(String[] args) throws IOException, InvalidPlaceException {
        optLoop();
    }

}
