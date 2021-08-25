package com.javapractice;
import java.util.ArrayList;
import java.util.LinkedList;


public class MyMapNode <K,V>implements INode<K>{
    K key;
    V value;
    MyMapNode<K,V> next;
    public  MyMapNode(K key,V value){
        this.key =key;
        this.value=value;
    }
    public K getKey()
    {
        return key;
    }
    public void setKey(K key)
    {
        this.key =key;
    }
    public INode<K> getNext()
    {
        return next;
    }
    public void setNext(INode<K>next)
    {
        this.next=(MyMapNode<K,V>)next;
    }
    public V getValue()
    {
        return this.value;
    }
    public void setValue(V value)
    {
        this.value=value;
    }

    @Override
    public String toString(){
        //
    }
    class LinkedHashMapTest{
        public class MyHashMap<K,V>{
            LinkedList<K> myLinkedList;
            public MyHashMap(){
                this.myLinkedList=new LinkedList<>();
            }
        }
    }
    public class LinkedHashMap<K,V>{
        private final int numBucket;
        ArrayList<LinkedList<K>> myBucketArray;


        public LinkedHashMap(){
        this.numBucket=10;
        this.myBucketArray=new ArrayList<>(numBucket);
        for(int i =0; i <numBucket; i++)
            this.myBucketArray.add(null);
        }
        private int getBucketIndex(K key)
        {
            int hashcode =Math.abs(key.hashCode());
            int index = hashcode%numBucket;
            return index;
        }
        public V get (K key)
        {
            int index =this.getBucketIndex(key);
            LinkedList<K> myLinkedList=this.myBucketArray.get(index);
            if(myLinkedList==null)
                return null;
            MyMapNode<K,V> myMapNode=(MyMapNode<K, V>) myLinkedList.search(key);
            return (myMapNode==null) ? null:myMapNode.getValue();
        }

    }
}
