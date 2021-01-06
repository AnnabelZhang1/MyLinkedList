public class MyLinkedList{

  private int size;
  private Node start, end;

  public MyLinkedList(){

  }

  public int size();

  public boolean add(String value);
  public boolean add(int index, String value);

  public String get(int index);
  public String set(int index, String value);
  public String toString();
}

//for methods with indexes, make sure to put the right exception
//tostring if uses whilenext, doesn't say whether double linked is correctly linked
//make another toString that is reversed to check
