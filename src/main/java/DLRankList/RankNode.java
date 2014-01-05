package DLRankList;

import DLList.Node;

public class RankNode<K, V> extends Rank<K, V> implements IRank<K, V>{

    private Node<Rank<K, V>> location;

    public RankNode(K key, V val) {
        super(key, val);
    }

    public RankNode(K key, V val, Node<Rank<K, V>> placement){
        super(key, val);
        location = placement;
    }

    protected Node<Rank<K, V>> location(){
        return location;
    }

    protected Node<Rank<K, V>> setLocation(Node<Rank<K, V>> placement){
        Node<Rank<K, V>> oldPos = location();
        location = placement;
        return oldPos;
    }

    protected K setKey(K key){
        K oldKey = getKey();
        k = key;
        return oldKey;
    }

    protected V setVal(V val){
        V oldVal = getVal();
        v = val;
        return oldVal;
    }
}
