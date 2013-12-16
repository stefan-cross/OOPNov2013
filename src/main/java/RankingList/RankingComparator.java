package RankingList;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public class RankingComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<T>) o1).compareTo(o2);
    }

}
