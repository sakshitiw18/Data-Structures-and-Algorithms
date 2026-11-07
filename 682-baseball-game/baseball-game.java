
class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("C")) {

                // Remove the last score
                stack.pop();

            } 
            else if (op.equals("D")) {

                // Double the last score
                int last = stack.peek();
                stack.push(last * 2);

            } 
            else if (op.equals("+")) {

                // Sum of last two scores
                int last = stack.pop();
                int secondLast = stack.peek();

                stack.push(last);
                stack.push(last + secondLast);

            } 
            else {

                // Convert string to integer
                stack.push(Integer.parseInt(op));
            }
        }

        // Calculate total score
        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
