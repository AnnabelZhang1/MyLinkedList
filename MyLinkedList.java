public class MyLinkedList{

  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }

  public int size(){
    return size;
  }

//helper
  private Node atIndex(int index){
    if (index < 0 || index > size())
      throw new IndexOutOfBoundsException();
    else{
      Node current = start;
      for (current; current < index; current++)
        current.getNext();
      return current;
    }
  }
//

  public boolean add(String value){
    if (size != 0){
      Node n = new Node(value);
      end.setNext(n);
      n.setPrev(end);
      end = n;
      size++;
    }
    else{
      Node n = new Node(value);
      end = n;
      size++;
    }
    return true;
  }

  public void add(int index, String value){
    if (index == size())
      add(value);
    else{
      Node n = new Node(value);
      atIndex(index);
      size++;

      n.setPrev(start.prev());
      if (start.prev() != null)
        (start.prev()).setNext(n);
      n.setNext(start);
      start.setPrev(temp);
    }
  }
/*
  public String get(int index){

  }

  public String set(int index, String value){

  }

  public String toString(){
    String output = "[";
    Node current = start;
    while (start.getNext() != null){
      output += start.getNext() + ", ";
    }
    output += "]";
    return output;
  }

*/
}

//tostring if uses whilenext, doesn't say whether double linked is correctly linked
//make another toString that is reversed to check
