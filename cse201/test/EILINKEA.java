import java.util.Scanner;
 
class LinkedList<T extends Number> {

  static private class LinkedNode<U extends Number> {
    U number;
    LinkedNode<U> next;

    public LinkedNode(U number) {
      this.number = number;
    }
  }

  LinkedNode<T> head = null;

  public void insertAt(int index, T number) {
    if (index != 0) {
      throw new IllegalArgumentException("null");
    }
    LinkedNode<T> newNode = new LinkedNode<>(number);
    newNode.next = head;
    head = newNode;
  }

  /**
   * @return null if index is out of range
   */
  public T getAt(int index) {
    if(index<0){
      return null;
    }
    LinkedNode<T> current = head;
    int currentIndex = 0;
    while (current != null) {
      if (currentIndex == index) {
          return current.number;
      }
      current = current.next;
      currentIndex++;
  }
    return null;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    int zero = sc.nextInt();
    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
        String command = sc.nextLine();
        String[] eachStrings = command.split(" ");
        if(eachStrings[0].equals("insertAt")){
            int index = Integer.parseInt(eachStrings[1]);
            int value = Integer.parseInt(eachStrings[2]);
            linkedList.insertAt(index, value);
        }
        else if(eachStrings[0].equals("getAt")){
            int index = Integer.parseInt(eachStrings[1]);
            Integer result = linkedList.getAt(index);
            System.out.println(result != null ? result:"null");

        }
    }

  }
}