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
// PART I

//helper
  private Node atIndex(int index){
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException();
    else{
      Node current = start;
      for (int count = 0; count < index; count++){
        if (current != null)
          current = current.getNext();
      }
      return current;
    }
  }
//

  public boolean add(String value){
    size++;
    if (start == null) {
        start = new Node(value);
        end = start;
        return true;
    }
    Node temp = new Node(value);
    end.setNext(temp);
    temp.setPrev(end);
    end = temp;
    return true;
  }

  public void add(int index, String value){
    if (index < 0 || index > size())
      throw new IndexOutOfBoundsException("index" + index + "is not within size");

    if (index == size())
      add(value);
    else if (index == 0){
      Node temp = new Node(value);
      temp.setNext(start);
      start.setPrev(temp);
      start = temp;
      size++;
    }
    else{
      Node temp = new Node(value);
      atIndex(index);
      size++;

      temp.setPrev(start.getPrev());
      if (start.getPrev() != null)
        (start.getPrev()).setNext(temp);
      temp.setNext(start);
      start.setPrev(temp);
      size++;
    }
  }

  public String get(int index){
    Node i = atIndex(index);
    return i.getData();
  }

  public String set(int index, String value){
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("Got index:" + index + "but size is" + size());

    String original = get(index);
    Node current = start;
    for (int i = 0; i < index; i++)
      current = current.getNext();
    current.setData(value);

    return original;
  }

  public String toString(){
    String output = "{";
    Node current = start;

    while (current != null){
      output += current.getData();
      if (current.getNext() != null)
        output += ", ";
      current = current.getNext();
    }

    output += "}";
    return output;
  }

  public String toStringReversed(){
    String output = "{";
    Node current = end;

    while (current != null){
      output += current.getData();
      if (current.getPrev() != null)
        output += ", ";
      current = current.getPrev();
    }

    output += "}";
    return output;
  }

// PART II

  public String remove(int index){
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("Got index:" + index + "but size is" + size());

    String first = start.getData();
    if (size() == 1){
      start = null;
      end = null;
      size = 0;
    }
    else if (size() > 1 && index == 0){ //remove head
      Node current = start.getNext();
      current.setPrev(null);
      start = current;
      size--;
    }
    if (size() > 1 && index == size - 1){ //remove tail
      first = end.getData();
      Node current = end.getPrev();
      current.setNext(null);
      end = current;
      size--;
    }
    if (size() > 1 && index > 0 && index < size() - 1){ //remove middle
      Node current = start;
      for (int i = 0; i < index; i++)
        current =current .getNext();
      first = current.getData();
      Node previous = current.getPrev();
      Node next = current.getNext();
      previous.setNext(next);
      next.setPrev(previous);
      size--;
    }
    return first;
  }

  public void extend(MyLinkedList other){
    if (size == 0 && other.size != 0){ //one empty one not
      start = other.start;
      end = other.end;
      other.start = null;
      other.end = null;
      size = other.size;
      other.size = 0;
    }
    if (size > 0 && other.size > 0){ //both not empty
      end.setNext(other.start);
      (other.start).setPrev(end);
      end = other.end;
      other.end = null;
      other.start = null;
      size = size + other.size;
      other.size = 0;
    }
  }

  public static void main(String[] args){
    System.out.println("PART ONE TEST:");
    MyLinkedList a = new MyLinkedList();
    a.add("Universal Peace");
    System.out.println(a.size()); //Prints 1
    System.out.println(a.get(0)); //Prints Universal Peace
    a.add(0, "Adeptus Temptation");
    System.out.println(a.size()); //Prints 2
    System.out.println(a.get(0)); //Prints Adeptus Temptation
    System.out.println(a.toString()); //Prints {Adeptus Temptation, Universal Peace}
    a.add("Cream Stew");
    a.set(0, "Jade Parcels");
    a.set(1, "Goulash");
    System.out.println(a.get(1)); //Prints Goulash
    System.out.println(a.get(2)); //Prints Cream Stew
    System.out.println(a.toString()); //Prints {Jade Parcels, Goulash, Cream Stew}
    System.out.println(a.toStringReversed()); //Prints {Cream Stew, Goulash, Jade Parcels}

    System.out.println();

    System.out.println("PART TWO TEST:");
    MyLinkedList b = new MyLinkedList();
    b.add("0"); b.add("1"); b.add("2"); b.add("3"); b.add("4");
    b.remove(0);
    b.remove(3);
    System.out.println(b.toString()); //Prints {1, 2, 3}
    MyLinkedList c = new MyLinkedList();
    c.add("Almond Tofu"); c.add("Emergency Food?");
    a.extend(c);
    System.out.println(a.toString()); //Prints {Jade Parcels, Goulash, Cream Stew, Almond Tofu, Emergency Food?}
  }

}
