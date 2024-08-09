class Solution{
    public record Pair (int r, int c){};

    public boolean isMagic(Pair st, Pair e, int[][]a){
        int colSum = 0;
        for(int i = st.c; i <= e.c; i++)
            colSum += a[st.r][i];

        TreeSet<Integer> set = new TreeSet<>();

        System.out.println(colSum);
        for(int i = st.r; i <= e.r; i++){
            int sum = 0;
            for(int j = st.c; j <= e.c; j++){
                sum += a[i][j];
                set.add(a[i][j]);
            }
            if(sum != colSum) return false;
        }

        int num  = 1;
        for(var v : set){
            if(v != num){
                return false;
            }
            num++;
        }
        System.out.println(set);
        for(int i = st.c; i <= e.c; i++){
            int sum = 0;
            for(int j = st.r; j <= e.r; j++){
                sum += a[j][i];
            }
            if(sum != colSum) return false;
        }

        int sum = 0;
        for(int i = st.r, j =st.c; i <= e.r; i++, j++){
            System.out.println("r -> " + i+ " " + "c ->" + i);
            sum += a[i][j];
        }
        if(sum != colSum) return false;
        System.out.println( "cur ->>" +  colSum);
        
        sum = 0;
        for(int j = e.c, i = st.r; j >= st.c; j--, i++){
            sum += a[i][j];
        }     
        System.out.println( "cur ->>" +  colSum);
        if(sum != colSum) return false;
        return true;
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        int n =  grid.length, m = grid[0].length; 
        int str = 0, stc = 0, er = 2, ec = 2;
        if(n < 2 || m < 2) return 0;

        while(er < n && ec < m ){
            cnt += isMagic(new Pair(str, stc), new Pair(er, ec), grid) ? 1: 0;
            stc++; ec++;

            if(er+1 >= n && ec>= m) break;
            else if(ec >= m){
                er++; str++;
                stc = 0;
                ec = 2;
            }
        }
        return cnt;
    }
}