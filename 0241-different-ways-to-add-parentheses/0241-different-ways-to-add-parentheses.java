class Solution {
    public boolean isOp(char c){
        return c=='-' || c=='+' || c=='*';
    }

    public List<Integer> helper(String e){
        List<Integer> arr = new ArrayList<>();

        for(int i =0; i < e.length(); i += 1){
            if(isOp(e.charAt(i))){
                List<Integer> left = helper(e.substring(0,i));    
                List<Integer> right = helper(e.substring(i+1, e.length()));


                for(int a : left){
                    for(int b : right){
                        if(e.charAt(i) == '-'){
                            arr.add(a-b);
                        }else if(e.charAt(i) == '+'){
                            arr.add(a+b);
                        }else{
                            arr.add(a*b);
                        }
                    }
                }
            }
        }

        if(arr.size() == 0){
            arr.add(Integer.valueOf(e));
        }
        return arr;
    }

    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> res =  helper(exp);    
        return res;
    }
}