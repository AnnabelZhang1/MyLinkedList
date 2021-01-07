public class Node{

  private String data;
  private Node next, prev;
  
  public Node(String value, Node n, Node p){
    data = value;
    next = n;
    prev = p;
  }

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
  public getNext(){
    return next;
  }

  public setNext(Node value){
    Node next1 = next;
    next = value;
    return next1;
  }

//prev
  public getPrev(){
    return prev;
  }

  public setPrev(Node value){
    Node prev1 = prev;
    prev = value;
    return prev1;
  }

  public String toString(){
    return "" + getData();
  }
}
//write get/set methods for all three instance variables(data, next, prev)
