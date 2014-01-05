package Library;

import DLList.EmptyListException;
import DLList.InvalidPlaceException;
import DLList.RankList;

public class Import {

    private static RankList sortedList = new RankList();

    public Import(){

    }

    public RankList RandomData() throws EmptyListException, InvalidPlaceException {
        Track t1 = new Track(); sortedList.insert(1, t1.setTrack("a", "a"));
        Track t1_1 = new Track(); sortedList.insert(21, t1_1.setTrack("a", "b"));
        Track t1_2 = new Track(); sortedList.insert(27, t1_2.setTrack("a", "c"));
        Track t1_3 = new Track(); sortedList.insert(52, t1_3.setTrack("a", "d"));

        Track t2 = new Track(); sortedList.insert(8, t2.setTrack("b", "b"));
        Track t3 = new Track(); sortedList.insert(0, t3.setTrack("c", "d"));
        Track t4 = new Track(); sortedList.insert(90, t4.setTrack("d", "d"));
        Track t5 = new Track(); sortedList.insert(9, t5.setTrack("e", "e"));
        Track t6 = new Track(); sortedList.insert(12, t6.setTrack("f", "f"));
        Track t7 = new Track(); sortedList.insert(23, t7.setTrack("g", "g"));
        Track t8 = new Track(); sortedList.insert(46, t8.setTrack("h", "h"));
        Track t9 = new Track(); sortedList.insert(23, t9.setTrack("i", "i"));
        Track t10 = new Track(); sortedList.insert(13, t10.setTrack("j", "j"));
        Track t11 = new Track(); sortedList.insert(9, t11.setTrack("k", "k"));
        Track t12 = new Track(); sortedList.insert(1, t12.setTrack("l", "l"));
        Track t13 = new Track(); sortedList.insert(23, t13.setTrack("c", "m"));
        Track t14 = new Track(); sortedList.insert(30, t14.setTrack("m", "d"));
        Track t15 = new Track(); sortedList.insert(123, t15.setTrack("n", "n"));
        Track t16 = new Track(); sortedList.insert(12, t16.setTrack("o", "o"));
        Track t17 = new Track(); sortedList.insert(22, t17.setTrack("p", "q"));
        Track t18 = new Track(); sortedList.insert(6, t18.setTrack("r", "r"));
        Track t19 = new Track(); sortedList.insert(3, t19.setTrack("s", "s"));

        return sortedList;
    }

}
