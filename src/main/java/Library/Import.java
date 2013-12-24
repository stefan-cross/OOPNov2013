package Library;

import DoubleLinkedList.PlacementList;

/**
 * User: stefancross
 * Date: 20/12/2013
 * Time: 18:50
 */
public class Import {

    private static PlacementList rankingList = new PlacementList();

    public Import(){

    }

    public PlacementList RandomData(){
        Track t1 = new Track(); rankingList.addFirst(t1.setTrack("a", "a").setTrackPlays(10).setTrackDownloads(9));
        Track t1_1 = new Track(); rankingList.addFirst(t1_1.setTrack("a", "b").setTrackPlays(23).setTrackDownloads(21));
        Track t1_2 = new Track(); rankingList.addFirst(t1_2.setTrack("a", "c").setTrackPlays(12).setTrackDownloads(27));
        Track t1_3 = new Track(); rankingList.addFirst(t1_3.setTrack("a", "d").setTrackPlays(13).setTrackDownloads(52));

        Track t2 = new Track(); rankingList.addFirst(t2.setTrack("b", "b").setTrackPlays(1).setTrackDownloads(8));
        Track t3 = new Track(); rankingList.addFirst(t3.setTrack("c", "d").setTrackPlays(0).setTrackDownloads(0));
        Track t4 = new Track(); rankingList.addFirst(t4.setTrack("d", "d").setTrackPlays(100).setTrackDownloads(90));
        Track t5 = new Track(); rankingList.addFirst(t5.setTrack("e", "e").setTrackPlays(10).setTrackDownloads(9));
        Track t6 = new Track(); rankingList.addFirst(t6.setTrack("f", "f").setTrackPlays(45).setTrackDownloads(12));
        Track t7 = new Track(); rankingList.addFirst(t7.setTrack("g", "g").setTrackPlays(23).setTrackDownloads(23));
        Track t8 = new Track(); rankingList.addFirst(t8.setTrack("h", "h").setTrackPlays(12).setTrackDownloads(46));
        Track t9 = new Track(); rankingList.addFirst(t9.setTrack("i", "i").setTrackPlays(78).setTrackDownloads(23));
        Track t10 = new Track(); rankingList.addFirst(t10.setTrack("j", "j").setTrackPlays(21).setTrackDownloads(13));
        Track t11 = new Track(); rankingList.addFirst(t11.setTrack("k", "k").setTrackPlays(23).setTrackDownloads(9));
        Track t12 = new Track(); rankingList.addFirst(t12.setTrack("l", "l").setTrackPlays(36).setTrackDownloads(1));
        Track t13 = new Track(); rankingList.addFirst(t13.setTrack("c", "m").setTrackPlays(64).setTrackDownloads(23));
        Track t14 = new Track(); rankingList.addFirst(t14.setTrack("m", "d").setTrackPlays(15).setTrackDownloads(30));
        Track t15 = new Track(); rankingList.addFirst(t15.setTrack("n", "n").setTrackPlays(34).setTrackDownloads(123));
        Track t16 = new Track(); rankingList.addFirst(t16.setTrack("o", "o").setTrackPlays(75).setTrackDownloads(12));
        Track t17 = new Track(); rankingList.addFirst(t17.setTrack("p", "q").setTrackPlays(13).setTrackDownloads(22));
        Track t18 = new Track(); rankingList.addFirst(t18.setTrack("r", "r").setTrackPlays(12).setTrackDownloads(6));
        Track t19 = new Track(); rankingList.addFirst(t19.setTrack("s", "s").setTrackPlays(71).setTrackDownloads(3));

        return rankingList;
    }

}
