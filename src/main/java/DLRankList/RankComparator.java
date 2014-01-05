package DLRankList;

import java.util.Comparator;

public class RankComparator<T> implements Comparator<T> {
    // Return -1 if first object is less, 1 is first object it greater
    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<T>) o1).compareTo(o2);
    }

}
