package Library;

import DoubleLinkedList.List;
import RankingList.SortedRankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 20/12/2013
 * Time: 18:50
 */
public class Import {

    private static List rankingList = new List();

    public Import(){

    }

    public List RandomData(){
        Track t1 = new Track(); rankingList.addFirst(t1.setTrack("a", "a").setPlays(10).setDownloads(9));
        Track t1_1 = new Track(); rankingList.addFirst(t1_1.setTrack("a", "b").setPlays(23).setDownloads(21));
        Track t1_2 = new Track(); rankingList.addFirst(t1_2.setTrack("a", "c").setPlays(12).setDownloads(27));
        Track t1_3 = new Track(); rankingList.addFirst(t1_3.setTrack("a", "d").setPlays(13).setDownloads(52));

        Track t2 = new Track(); rankingList.addFirst(t2.setTrack("b", "b").setPlays(1).setDownloads(8));
        Track t3 = new Track(); rankingList.addFirst(t3.setTrack("c", "d").setPlays(0).setDownloads(0));
        Track t4 = new Track(); rankingList.addFirst(t4.setTrack("d", "d").setPlays(100).setDownloads(90));
        Track t5 = new Track(); rankingList.addFirst(t5.setTrack("e", "e").setPlays(10).setDownloads(9));
        Track t6 = new Track(); rankingList.addFirst(t6.setTrack("f", "f").setPlays(45).setDownloads(12));
        Track t7 = new Track(); rankingList.addFirst(t7.setTrack("g", "g").setPlays(23).setDownloads(23));
        Track t8 = new Track(); rankingList.addFirst(t8.setTrack("h", "h").setPlays(12).setDownloads(46));
        Track t9 = new Track(); rankingList.addFirst(t9.setTrack("i", "i").setPlays(78).setDownloads(23));
        Track t10 = new Track(); rankingList.addFirst(t10.setTrack("j", "j").setPlays(21).setDownloads(13));
        Track t11 = new Track(); rankingList.addFirst(t11.setTrack("k", "k").setPlays(23).setDownloads(9));
        Track t12 = new Track(); rankingList.addFirst(t12.setTrack("l", "l").setPlays(36).setDownloads(1));
        Track t13 = new Track(); rankingList.addFirst(t13.setTrack("c", "m").setPlays(64).setDownloads(23));
        Track t14 = new Track(); rankingList.addFirst(t14.setTrack("m", "d").setPlays(15).setDownloads(30));
        Track t15 = new Track(); rankingList.addFirst(t15.setTrack("n", "n").setPlays(34).setDownloads(123));
        Track t16 = new Track(); rankingList.addFirst(t16.setTrack("o", "o").setPlays(75).setDownloads(12));
        Track t17 = new Track(); rankingList.addFirst(t17.setTrack("p", "q").setPlays(13).setDownloads(22));
        Track t18 = new Track(); rankingList.addFirst(t18.setTrack("r", "r").setPlays(12).setDownloads(6));
        Track t19 = new Track(); rankingList.addFirst(t19.setTrack("s", "s").setPlays(71).setDownloads(3));

        return rankingList;
    }

}
