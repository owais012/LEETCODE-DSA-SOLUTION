class Solution {
    public String generateTag(String caption) {
        //convert all to string array using split by " ",
        //transform each string such that it follows all three rules
        caption = caption.trim();
        if(caption.length() == 0)
            return "#";
        String[]str = caption.split("\\s+");
        int n = str.length;
    
        for(int i = 0; i < n; i += 1){
            StringBuilder sb = new StringBuilder(str[i].toLowerCase());
            if(i > 0)
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            if(i == 0){
                sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
            }
            str[i] = sb.toString();
        }

        StringBuilder res = new StringBuilder("#");

        outerLoop:
        for(var s : str){
            for(int i = 0; i < s.length(); i += 1){
                res.append(s.charAt(i));
                if(res.length() == 100)
                    break outerLoop;
            }
        }
        System.out.println(res.length());
        return res.toString();
    }
}