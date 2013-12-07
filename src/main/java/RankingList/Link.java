package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 07/12/2013
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */
public class Link {

    private Object head;
    private Link tail;

    public Link(Object item){
        head = item;
        tail = null;
    }

    public Link(Object item, Link next){
        head = item;
        tail = next;
    }

    public void setHead(Object item){
        head = item;
    }
}
