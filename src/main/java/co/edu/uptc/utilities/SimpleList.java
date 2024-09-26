package co.edu.uptc.utilities;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList <T> implements List<T>{

    private Node<T> header;
    private Node<T> lastNode;
    public int size = 0;

    public SimpleList(){
        header = null;
        lastNode = null;
    }
    
    @Override
    public boolean add(T e) {
        Node<T> newNode = new Node<T>();
        newNode.setInfo(e); 
        newNode.setNext(null);
        size +=  1;
        if(isEmpty()){
            header = newNode;
            lastNode = header;
        }else{
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

        // test algoritm 
    public void showList(){
        Node<T> aux =  header;
        while (aux!=null) {
            System.out.println(aux.getInfo());
            aux = aux.getNext();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        Node<T> current = header;
    for (int i = 0; i < index; i++) {
        current = current.getNext();
    }

    return current.getInfo();
    }

    @Override
    public T set(int index, T element) {
        Node<T> current = header;
    for (int i = 0; i < index; i++) {
        current = current.getNext();
    }

    T oldInfo = current.getInfo();
    current.setInfo(element);
    return oldInfo;
    }
    
    @Override
    public Iterator<T> iterator() {
       return new SimpleListIterator<>(header);
    }

    @Override   
    public boolean contains(Object o) {
        Node<T> aux = header;
        boolean contains = false;
        while (aux != null && contains == false) {
            if(aux.getInfo().equals(o)){
                contains = true;
            }
            aux = aux.getNext();
        }
        return contains;
    }

    @Override
    public Object[] toArray() {
        Object [] array = new Object[size];
        Node<T> aux = header;
        for (int i = 0; i < size; i++) {
            array[i] = aux.getInfo();
            aux = aux.getNext();
        }
        return array;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> aux = header;
        int index = indexOf(o);
        boolean isRemoved = false;

        for (int i = 0; i < index-1; i++) {
            aux = aux.getNext();
        }

        Node<T> remove = aux.getNext();
        if(remove != null){
            aux.setNext(remove.getNext());
            isRemoved =true;
            size -= 1;
        }
        return isRemoved;
    }

    @Override
    public void clear() {
        header = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNode = new Node<>();
        newNode.setInfo(element);

        if (index == 0) {
            newNode.setNext(header); 
            header = newNode; 
        } else {
            Node<T> aux = header; 
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext(); 
            }
            newNode.setNext(aux.getNext()); 
            aux.setNext(newNode);
        }

        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> aux = header;
        for (int i = 0; i < index-1; i++) {
            aux = aux.getNext();
        }
        Node<T> remove = aux.getNext();
        if(remove != null){
            aux.setNext(remove.getNext());
            size -= 1;
        }
        T info = aux.getInfo();
        return info;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> aux = header;
        int index = -1;
        int i = 0;
        while (aux != null && index == -1) {
            if (aux.getInfo().equals(o)) {
                index = i; 
            } else {
                aux = aux.getNext(); 
                i++; 
            }
        }
        return index;  
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> aux = header;
        int index = -1; 
        for (int i = 0; i < size; i++) {
            if (aux.getInfo().equals(o)) {
                index = i; 
            }
            aux = aux.getNext(); 
        }
        return index;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }
    
    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }
    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    // VERSION 1 
    // public void add(String info){
    //     Node node = new Node();
    //     node.setInfo(info);
    //     node.setNext(null);
    //     header = node;
    // }

    // public void add(String info){
    //     Node newNode = new Node();
    //     newNode.setInfo(info); 
    //     newNode.setNext(null);
    //     if(isEmpty()){
    //         header = newNode;
    //     }else{
    //         findLastNode().setNext(newNode);
    //     }
    // }

    // public Node findLastNode(){
    //     Node last = header;
    //     while (last.getNext()!=null) {
    //         last = last.getNext();
    //     }
    //     return last;
    // }


    // //TODO: Ingresar al inicio
    // public void addToTop(String info){
    //     Node newNode = new Node();
    //     newNode.setInfo(info); 
    //     newNode.setNext(header);
    //     header = newNode;
    // }

    // //Añadir después de un nodo indicado
    // public void addAfterNode(String key, String info) {
    //     Node foundNode = findNode(key);
    //     if (foundNode != null) { 
    //         Node newNode = new Node();
    //         newNode.setInfo(info);
    //         newNode.setNext(foundNode.getNext()); 
    //         foundNode.setNext(newNode); 
    //     }
    // }

    // public Node findNode(String key) {
    //     Node auxNode = header;
    //     Node foundNode = null;
    //     boolean itIs = false;
    //     while (auxNode != null && !itIs) {
    //         if (auxNode.getInfo().equals(key)) {
    //             itIs = true;
    //             foundNode = auxNode;
    //         }
    //         auxNode = auxNode.getNext();
    //     }
    //     return foundNode; 
    // }
    

}
