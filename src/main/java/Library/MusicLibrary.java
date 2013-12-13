package Library;

import RankingStack.*;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 07/12/2013
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class MusicLibrary {

    private RankingStack libraryList;

    public MusicLibrary(){
        this.libraryList = new RankingStack();
    }

    public void printList() throws ListException {
        for(int i = 0; i < libraryList.size(); i++){
            System.out.println(libraryList.iterate());
        }

        if(this.libraryList.isEmpty()){
            System.out.println("Library empty");
        }

    }

    public void add(Track track){
        this.libraryList.push(track);
    }
}
