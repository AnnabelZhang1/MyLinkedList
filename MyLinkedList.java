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

  public String get(int index){
    Node i = atIndex(index);
    return i.data();
  }

  public String set(int index, String value){
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("Got index:" + index + "but size is" + size());
    else{
      if (index == 0){
        Node n = new Node(value);
        next = start.getNext();
        prev = null;
        next.setPrev(n);
        start = n
      }
      else if (index == size() - 1){
        add(value);
      }
      else{
        Node n = atIndex(index);
        Node n1 = new Node(value);
        (n.getNext()).setPrev(n1);
        (n.getPrev()).setNext(n1);
      }
    }
    return get(index);
  }

  public String toString(){
    String output = "{";
    Node current = start;

    while (current != null){
      output += current.toString();
      if (current.getNext() != null)
        output += ", ";
      current = current.getNext();
    }

    output += "}";
    return output;
  }

  public String toReversed(){
    String output = "{";
    Node current = end;
    while (current != null){
      output += current.toString();
      if (current.getPrev() != null)
        output += ", ";
      current = current.getPrev();
    }

    output += "}";
    return output;
  }
/*
  public void main(String[] args){

  }
*/
}

//tostring if uses whilenext, doesn't say whether double linked is correctly linked
//make another toString that is reversed to check
