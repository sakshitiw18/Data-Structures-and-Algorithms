class Solution { 
    public String frequencySort(String s) { 

        HashMap<Character, Integer> map = new HashMap<>(); 

        for (char c : s.toCharArray()) { 
            map.put(c, map.getOrDefault(c, 0) + 1); 
        } 

        List<Character>[] bucket = new ArrayList[s.length() + 1]; 

        for (char c : map.keySet()) { 
            int freq = map.get(c); 

            if (bucket[freq] == null) { 
                bucket[freq] = new ArrayList<>(); 
            } 

            bucket[freq].add(c); 
        } 

        StringBuilder ans = new StringBuilder(); 

        for (int freq = bucket.length - 1; freq >= 1; freq--) { 

            if (bucket[freq] != null) { 
                for (char c : bucket[freq]) { 
                    for (int j = 0; j < freq; j++) { 
                        ans.append(c); 
                    } 
                } 
            } 
        } 

        return ans.toString(); 
    } 
}