package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 07/12/2013
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class MusicLibrary {

    private RankingList libraryList;

    public MusicLibrary(){
        this.libraryList = new RankingList();
    }

    public void printList() throws ListException {
        for(int i = 0; i < libraryList.size(); i++){
            Track t = this.libraryList.top();
            System.out.println(t.toString());
        }

        if(this.libraryList.isEmpty()){
            System.out.println("Library empty");
        }

    }

    public void add(Track track){
        this.libraryList.push(track);
    }
}
