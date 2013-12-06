package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:08
 *
 * RankingList
 *
 */
public abstract class RankingList implements IRankingList {
// OVERVIEW: Provides an Ordered List DataType that can arrange/order by Track play count or download of an artist initially
// but further abstraction would allow for any type using generics

// ABSTRACT FUNCTION: explains the interpretation of the rep, mapping state of each legal representation object to
// the abstract object it is intended to represent

// REPRESENTATION INVARIANT: defines all common assumptions that underlie the implementations of a types operations
// Defining which representations are legal by mapping each rep object to either true (if the rep is legal) or false
// (if its rep is not legal)


    // VARIABLES - the rep
    private Artist artist;
    private Title title;

    // CONSTRUCTOR
    public RankingList() {

    }

    // METHODS
    public void add(){
        // REQUIRES: This clause states any constraints on use
        // MODIFIES: This clause identifies all modified inputs
        // EFFECTS: This clause defines the behaviour
    }

    public void remove(){

    }

//    public Track top(){
//        return Track;
//    }
//
//    public Track iterator() {
//        return Track;
//    }

}
