package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:13
 */
public interface IRank<E> {

    // Returns an object at a given ranking
    public E element() throws InvalidPlaceException;
}
