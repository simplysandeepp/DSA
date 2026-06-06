class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty()) {
                int idx = stack.peek();
                int tempTop = temperatures[idx];

                if (tempTop < currTemp) {
                    days[idx] = i - idx;
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        return days;
    }
}