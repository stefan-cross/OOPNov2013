package Stack;

import Library.Track;

public class Stack implements IStack {

    protected LinkedNode top;
    int size = 0;

    // CONSTRUCTOR
    public Stack() {
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
        LinkedNode cur = top;

        while(cur != null){
            size++;
            cur = cur.getNext();
        }

        return size;
    }

    public String iterate(){

        ListIterator listIterator = new ListIterator();

        if(listIterator.hasNext()){
            try {
                return listIterator.next();
            } catch (ListException e) {
                e.printStackTrace();
            }
        }
        return "No more to iterate through...";
    }

    //TODO implement comparator


    protected class ListIterator {

        // An index for the items in list
        private int i;

        // Constructor to reset index
        protected ListIterator(){
            this.i = 0;
        }

        public boolean hasNext(){
            return (i < size);
        }

        public String next() throws ListException {
            if(i < size){
                i++;
                return next().toString();
            } else{
                throw new ListException();
            }
        }

    }

}



