package co.edu.uptc.utilities;

import java.util.Iterator;

public class SimpleListIterator<T> implements Iterator<T>{

    private Node<T> currentNode;

    public SimpleListIterator(Node<T> header){
        this.currentNode = header;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new java.util.NoSuchElementException();
        }
            T info = currentNode.getInfo();
            currentNode = currentNode.getNext();
        return info;
    }
    

}
