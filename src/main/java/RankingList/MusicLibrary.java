package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 07/12/2013
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class MusicLibrary {

    private RankingList list;

    public MusicLibrary(){
        this.list = new RankingList();
    }

    private void printList(){

        System.out.println(list.toString());

    }
}
