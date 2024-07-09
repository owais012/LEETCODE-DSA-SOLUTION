class Solution {
    public double averageWaitingTime(int[][] cust) {
        double sum = 0;

        int start = cust[0][0], finish = cust[0][0];

        for(int i = 0; i < cust.length; i++){
            if(cust[i][0] > start)
                start = cust[i][0];
            finish = (start + cust[i][1]);
            System.out.println(finish +" "+cust[i][0]);
            sum += finish - cust[i][0];
            start = finish;

        }

        return sum/cust.length;
    }
}