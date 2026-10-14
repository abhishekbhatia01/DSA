class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            map1.put(a, map1.getOrDefault(a, 0)+1);
            map2.put(b, map2.getOrDefault(b, 0)+1);
        }

        if(map1.equals(map2)){
            return true;
        }

        for(int i=n; i<m; i++){
            char in = s2.charAt(i);
            char out = s2.charAt(i-n);

            map2.put(in, map2.getOrDefault(in, 0) + 1);
            map2.put(out, map2.getOrDefault(out, 0) - 1);

            if(map2.get(out) == 0){
                map2.remove(out);
            }

            if(map1.equals(map2)){
                return true;
            }
        }

        return false;
    }
}