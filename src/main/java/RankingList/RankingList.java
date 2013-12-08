package RankingList;

public class RankingList implements IRankingList {

    private LinkedNode top;

    // CONSTRUCTOR
    public RankingList() {
        top = null;
    }

    // METHODS
    public void push(Track track){
        top = new LinkedNode(track, top);
    }

    public Track pop() throws ListException {
        Track head = this.top();
        top = top.getNext();

        return head;
    }

    public Track top() throws ListException{
        if (this.isEmpty())
        {
            throw new ListException("Empty List");
        }
        else
        {
            return top.getItem();
        }
    }

    public boolean isEmpty(){
        return (top == null);
    }

    public int size(){
        int size = 0;
        LinkedNode cur = top;

        while(cur != null){
            size++;
            cur = cur.getNext();
        }

        return size;
    }



    //TODO implement iterator


    //TODO implement comparator




}
