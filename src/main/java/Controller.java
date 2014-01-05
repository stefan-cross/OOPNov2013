//import Stack.*;
//import ImLibrary.*;
//
//import java.util.Iterator;
//import java.util.Scanner;
//
///**
// * User: stefancross
// * Date: 22/12/2013
// * Time: 10:58
// */
//public class Controller {
//
//    // Sorted most popular track by plays or downloads
//    public SortedRankList mostPopular(List rankingList, Class<?> cls) throws InvalidPlaceException, EmptyListException {
//        SortedRankList sortedRankingList = new SortedRankList();
//        Iterator it = rankingList.iterator();
//        while(it.hasNext()){
//            Track track = (Track) it.next();
//            if(cls == IPlays.class){
//                sortedRankingList.insert(track.getTrackPlays(), track.getArtist() + " - " + track.getTitle());
//            } else if(cls == IDownloads.class){
//                sortedRankingList.insert(track.getTrackDownloads(), track.getArtist() + " - " + track.getTitle());
//            }
//        }
//        return sortedRankingList;
//    }
//
//
//    // Sorts artist most popular track by plays or downloads
//    public SortedRankList mostPopularTrackOf(Scanner input, List rankingList, Class<?> cls){
//        System.out.println("Please enter the artist:");
//        String search = input.next();
//        SortedRankList sortedRankingList = new SortedRankList();
//        Iterator it = rankingList.iterator();
//        while(it.hasNext()){
//            Track searchingTrack = (Track) it.next();
//            if(searchingTrack.getArtist().equals(search)){
//                try {
//                    if(cls == IPlays.class){
//                        sortedRankingList.insert(searchingTrack.getTrackPlays(), searchingTrack.getArtist() + " - " + searchingTrack.getTitle());
//                    } else if(cls == IDownloads.class) {
//                        sortedRankingList.insert(searchingTrack.getTrackDownloads(), searchingTrack.getArtist() + " - " + searchingTrack.getTitle());
//                    }
//                } catch (EmptyListException e) {
//                    e.printStackTrace();
//                } catch (InvalidPlaceException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return sortedRankingList;
//    }
//
//    // Increments an artist track play or download count
//    public void incTrackOf(Scanner input, List rankingList, Class<?> cls){
//        System.out.println("Please enter the artist:");
//        String artistInput = input.next();
//
//        System.out.println("Please enter the track:");
//        String trackInput = input.next();
//
//        Boolean found = false;
//        SortedRankList sortedRankingList = new SortedRankList();
//        Iterator it = rankingList.iterator();
//
//        while(it.hasNext()){
//            Track incTrack = (Track) it.next();
//            if(incTrack.getArtist().equals(artistInput) && incTrack.getTitle().equals(trackInput)){
//                if(cls == IPlays.class){
//                    incTrack.incTrackPlays();
//                } else if(cls == IDownloads.class) {
//                    incTrack.incTrackDownloads();
//                }
//                found = true;
//            }
//        }
//        if(!found){
//            System.out.println("Artist and track match not found");
//        }
//
//    }
//
//}
