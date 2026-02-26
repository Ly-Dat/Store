

public class Q7 {
    public static void main(String[] args) {
        Dice_7 dice4 = new Dice_7(4);
        Dice_7 dice6 = new Dice_7(6);
        Dice_7 dice8 = new Dice_7(8);
        Dice_7 dice10 = new Dice_7(10);
        Dice_7 dice12 = new Dice_7(12);
        Dice_7 dice20 = new Dice_7(20);

        Dice_7 dice = dice4;

        Player player1 = new Player("A");
        Player player2 = new Player("B");

        // -- while point = 1
        while(player1.getPoint()!=1 && player2.getPoint()!=1){
            player1.play(dice);
            player2.play(dice);
            System.out.println(player1+"\n"+player2+"\n---------");
        }
        if(player1.getPoint()==1){
            System.out.println("Winner: "+player1.getName());
        }
        else{
            System.out.println("Winner: "+player2.getName());
        }

        // -- in n time 
        // int n = 20;
        // while(player1.getPoint()!=1 && player2.getPoint()!=1 && n>0){
        //     player1.play(dice);
        //     player2.play(dice);
        //     System.out.println(player1+"\n"+player2+"\n---------");
        //     n--;
        // }
        // if(player1.getPoint()==1){
        //     System.out.println("Winner: "+player1.getName());
        // }
        // else if(player2.getPoint()==1){
        //     System.out.println("Winner: "+player2.getName());
        // }
        // else{
        //     if(player1.getPoint()<player2.getPoint()){
        //         System.out.println("Winner: "+player1.getName());
        //     }
        //     else if(player1.getPoint()==player2.getPoint()){
        //         System.out.println("both are the same point");
        //     }
        //     else{
        //         System.out.println("Winner: "+player2.getName());
        //     }
        // }
    }
}
