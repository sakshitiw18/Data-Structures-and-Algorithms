
class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(0, s, path, ans);

        return ans;
    }

    public void backtrack(int index, String s,
                          List<String> path,
                          List<List<String>> ans) {

        // If we reach the end, we found a valid partition
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring
        for (int i = index; i < s.length(); i++) {

            String sub = s.substring(index, i + 1);

            if (isPalindrome(sub)) {

                path.add(sub);

                backtrack(i + 1, s, path, ans);

                // Backtracking
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
