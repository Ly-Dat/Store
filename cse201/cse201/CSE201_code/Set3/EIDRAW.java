import java.util.Scanner;

class EIDRAW {
   static Scanner sc;
   static StringBuilder sb;

   static {
      sc = new Scanner(System.in);
      sb = new StringBuilder();
   }

   EIDRAW() {
   }

   public static void main(String[] args) {
      int colSize = sc.nextInt();
      int rowSize = colSize * 4;
      char[][] pic = new char[colSize][rowSize];
      int countHead = 0;
      int countTail = rowSize - 1;

      int row;
      int col;
      for(row = 0; row < colSize; ++row) {
         for(col = 0; col < rowSize; ++col) {
            if (col != countHead && col != countHead + colSize * 2) {
               if (col != countTail && col != countTail - colSize * 2) {
                  pic[row][col] = ' ';
               } else {
                  pic[row][col] = '/';
               }
            } else {
               pic[row][col] = '\\';
            }
         }

         ++countHead;
         --countTail;
      }

      for(row = 0; row < colSize; ++row) {
         for(col = 0; col < rowSize; ++col) {
            sb.append(pic[row][col]);
         }

         if (row != colSize - 1) {
            sb.append('\n');
         }
      }

      System.out.println(sb);
   }
}
