Scanner sc =new Scanner(System.in);
        int[] num_month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        double[] rates = {3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};
        int month=sc.nextInt();
        double money=0;
        if (month > 12) {
            int i = month / 12;
            for (int j = 0; j < i; j++) {
                for(int k=0; k<12; k++){
                    long money_in = sc.nextLong();
                    money+=money_in;
                    money+=money*((double)1/12)*rates[k]/100;
                }
            }
            month = month % 12;
        }
        for(int i=0; i<month; i++){
            long money_in = sc.nextLong();
            money+=money_in;
            money+=money*((double)1/12)*rates[i]/100;
        }
        System.out.println(Math.round(money));