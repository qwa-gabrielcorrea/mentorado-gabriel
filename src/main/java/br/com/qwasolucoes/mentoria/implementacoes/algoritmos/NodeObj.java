package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

public class NodeObj {

	private Object value; 
    private NodeObj next;
    private NodeObj previous;

    public NodeObj(Object value){
        this.value = value;
        this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public NodeObj getNext() {
        return next;
    }
    
    public void setNext(NodeObj next) {
        this.next = next;
    }

    public NodeObj getPrevious() {
        return previous;
    }
    
    public void setPrevious(NodeObj next) {
        this.previous = previous;
    }
}
