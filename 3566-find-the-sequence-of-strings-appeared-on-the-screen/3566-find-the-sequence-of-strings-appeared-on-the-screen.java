class Solution {
    public List<String> stringSequence(String target) {
        List<String> arr = new ArrayList<>();
        int n = target.length();

        for (int i = 0; i < n; i += 1) {
            StringBuilder sb = new StringBuilder();
            if (arr.size() > 0) {
                sb.append(arr.get(arr.size() - 1));
            }
            sb.append("a");
            arr.add(sb.toString());

            while (sb.charAt(i) < target.charAt(i)) {
                char next = (char) (sb.charAt(i) + 1);
                if (sb.charAt(i) == 'z') {
                    next = 'a';
                }
                sb.setCharAt(i, next);
                arr.add(sb.toString());

            }

        }

        return arr;
    }
}