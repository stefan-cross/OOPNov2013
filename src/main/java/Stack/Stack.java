package Stack;

public class Stack<T> implements IStack<T> {

    protected LinkedNode top;
    int size = 0;

    // CONSTRUCTOR
    public Stack() {
        top = null;
    }

    // METHODS
    public void push(T t){
        top = new LinkedNode(t, top);
    }

    public T pop() throws StackException {
        T head = this.top();
        top = top.getNext();

        return head;
    }

    public T top() throws StackException {
        if (this.isEmpty())
        {
            throw new StackException("Empty PlacementList");
        }
        else
        {
            return (T) top.getItem();
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

        StackIterator stackIterator = new StackIterator();

        if(stackIterator.hasNext()){
            try {
                return stackIterator.next();
            } catch (StackException e) {
                e.printStackTrace();
            }
        }
        return "No more to iterate through...";
    }

    //TODO implement comparator


    protected class StackIterator {

        // An index for the items in placementList
        private int i;

        // Constructor to reset index
        protected StackIterator(){
            this.i = 0;
        }

        public boolean hasNext(){
            return (i < size);
        }

        public String next() throws StackException {
            if(i < size){
                i++;
                return next().toString();
            } else{
                throw new StackException();
            }
        }

    }

}



