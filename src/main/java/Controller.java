import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;
import DoubleLinkedList.PlacementList;
import Library.ICount;
import Library.Track;
import RankingList.IRank;
import RankingList.Rank;
import RankingList.SortedRankingList;

import java.util.Iterator;
import java.util.Scanner;

/**
 * User: stefancross
 * Date: 22/12/2013
 * Time: 10:58
 */
public class Controller<K, V> {

    // Return number of times a track has been downloaded
    public Rank<K, V> downloads(SortedRankingList<K, V> sortList, Rank<K, V> r) {
        Iterator it = sortList.iterator();
        while(it.hasNext()){
            Rank<K, V> rank = (Rank)it.next();
            // value is equal to track searched for...
            //if(equals(rank.getVal(), r)){

            //}
            //rank.getKey();
        }
        return r;
}







    // Sorted most popular track by plays or downloads
    public SortedRankingList mostPopular(SortedRankingList sortList) throws InvalidPlaceException, EmptyListException {
        SortedRankingList sortedRankingList = new SortedRankingList();
        Iterator it = sortList.iterator();
        while(it.hasNext()){
            Track track = (Track) it.next();
            //sortedRankingList.insert(track.getCount(), track.getArtist() + " - " + track.getTitle());

        }
        return sortedRankingList;
    }


    // Sorts artist most popular track by plays or downloads
    public SortedRankingList mostPopularTrackOf(Scanner input, PlacementList rankingList){
        System.out.println("Please enter the artist:");
        String search = input.next();
        SortedRankingList sortedRankingList = new SortedRankingList();
        Iterator it = rankingList.iterator();
        while(it.hasNext()){
            Track searchingTrack = (Track) it.next();
            if(searchingTrack.getArtist().equals(search)){

            }
        }
       return sortedRankingList;
    }

    // Increments an artist track play or download count
    public void incTrackOf(Scanner input, PlacementList rankingList){
        System.out.println("Please enter the artist:");
        String artistInput = input.next();

        System.out.println("Please enter the track:");
        String trackInput = input.next();

        Boolean found = false;
        SortedRankingList sortedRankingList = new SortedRankingList();
        Iterator it = rankingList.iterator();

        while(it.hasNext()){
            Track incTrack = (Track) it.next();
            if(incTrack.getArtist().equals(artistInput) && incTrack.getTitle().equals(trackInput)){
                //incTrack.incCount();
                found = true;
            }
        }
        if(!found){
            System.out.println("Artist and track match not found");
        }

    }

}
