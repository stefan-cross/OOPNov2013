package Library;

import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.List;
import RankingList.SortedRankingList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 22/12/2013
 * Time: 10:58
 */
public class Controller {

    public SortedRankingList mostPopular(List rankingList, Class<?> cls) throws InvalidPlaceException, EmptyListException {

        SortedRankingList sortedRankingList = new SortedRankingList();
        Iterator dlIt = rankingList.iterator();

        while(dlIt.hasNext()){

            Track downloadsTrack = (Track) dlIt.next();

            if(cls == IPlays.class){
                sortedRankingList.insert(downloadsTrack.getTrackPlays(), downloadsTrack.getArtist() + " - " + downloadsTrack.getTitle());
            } else if(cls == IDownloads.class){
                sortedRankingList.insert(downloadsTrack.getTrackDownloads(), downloadsTrack.getArtist() + " - " + downloadsTrack.getTitle());
            }
        }
        return sortedRankingList;
    }

    public SortedRankingList mostPopularTrackOf(Scanner input, List rankingList, Class<?> cls){
        System.out.println("Please enter the artist:");
        String search = input.next();

        SortedRankingList searchRankingList = new SortedRankingList();
        Iterator searchIt = rankingList.iterator();

        while(searchIt.hasNext()){
            Track searchingTrack = (Track) searchIt.next();
            if(searchingTrack.getArtist().equals(search)){
                try {
                    if(cls == IPlays.class){
                        searchRankingList.insert(searchingTrack.getTrackPlays(), searchingTrack.getArtist() + " - " + searchingTrack.getTitle());
                    } else if(cls == IDownloads.class) {
                        searchRankingList.insert(searchingTrack.getTrackDownloads(), searchingTrack.getArtist() + " - " + searchingTrack.getTitle());
                    }
                } catch (EmptyListException e) {
                    e.printStackTrace();
                } catch (InvalidPlaceException e) {
                    e.printStackTrace();
                }
            }
        }
       return searchRankingList;
    }

    public void incTrackOf(Scanner input, List rankingList, Class<?> cls){
        System.out.println("Please enter the artist:");
        String artistInput = input.next();

        System.out.println("Please enter the track:");
        String trackInput = input.next();

        Iterator incArtIt = rankingList.iterator();
        Boolean found = false;

        while(incArtIt.hasNext()){
            Track incTrack = (Track) incArtIt.next();
            if(incTrack.getArtist().equals(artistInput) && incTrack.getArtist().equals(trackInput)){
                if(cls == IPlays.class){
                    incTrack.incTrackPlays();
                } else if(cls == IDownloads.class) {
                    incTrack.incTrackDownloads();
                }
                found = true;
            }
        }

        if(!found){
            System.out.println("Artist and track match not found");
        }

    }

}
