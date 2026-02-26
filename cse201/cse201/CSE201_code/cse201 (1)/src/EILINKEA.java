import java.util.Scanner;

class EILINKEA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> linkedList = new LinkedList<>();

        int num = sc.nextInt();
        int numberOfCommands = sc.nextInt();

        for (int i = 0; i < numberOfCommands; i++) {
            String input = sc.next();
            if (input.equals("insertAt")) {
                linkedList.insertAt(sc.nextInt(), sc.nextInt());
            }else{
               sb.append(linkedList.getAt(sc.nextInt())).append('\n') ;
            }
        }
        System.out.println(sb);
    }

    static class LinkedList<T extends Number> {

        static private class LinkedNode<U extends Number> {
            U number;
            LinkedNode<U> next;

            public LinkedNode(U number) {
                this.number = number;
            }
        }

        LinkedNode<T> head = null;

        public void insertAt(int index, T number) {
            LinkedNode<T> node = new LinkedNode<>(number);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        /**
         * @return null if index is out of range
         */
        public T getAt(int index) {
            LinkedNode<T> temp = head;

            if (temp == null) {
                return null;
            } else {
                if (index == 0) {
                    return temp.number;
                } else {
                    for (int i = 0; i < index; i++) {
                        if (temp.next == null) {
                            return null;
                        } else {
                            temp = temp.next;
                        }
                    }
                }

            }

            return temp.number;
        }

    }

}
