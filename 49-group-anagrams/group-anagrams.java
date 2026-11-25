
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];

            // Convert word into character array
            char[] arr = word.toCharArray();

            // Sort characters
            Arrays.sort(arr);

            // Sorted word becomes the key
            String key = new String(arr);

            // If key is not present, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original word to its group
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
