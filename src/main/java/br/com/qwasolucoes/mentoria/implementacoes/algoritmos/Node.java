package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

public class Node {

    private Object value; 
    private Node next;

    public Node(Object value){
        this.value = value;
        this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getNext() {
        return next;
    }
    
    public void setNext(Object next) {
        this.next = next;
    }
    
}
