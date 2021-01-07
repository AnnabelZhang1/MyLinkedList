public class Node{

  public Node(String value, Node n, Node p){
    data = value;
    next = n;
    prev = p;
  }

  private String data;
  private Node next, prev;

//data
  public String getData(){
    return data;
  }

  public String setData(String value){
    String old = data;
    data = value;
    return old;
  }

//next
  public getNext(next){
    return next;
  }

  public setNext(next){
  
  }

//prev
  public getPrev(prev){
    return Node;
  }

  public setPrev(prev){

  }

}
//write get/set methods for all three instance variables(data, next, prev)
