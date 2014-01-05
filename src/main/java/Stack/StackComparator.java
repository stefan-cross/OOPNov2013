package Stack;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 05/01/2014
 * Time: 00:40
 */
public class StackComparator<T> implements Comparator<T> {
    // Return -1 if first object is less, 1 is first object it greater
    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<T>) o1).compareTo(o2);
    }
}
