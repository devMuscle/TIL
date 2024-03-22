class Solution {

    private static int count = 0;

    private void DFS(int index, int result, int target, int[] numbers) {
        if(index == numbers.length) {
            if(result == target) count++;

            return;
        }

        DFS(index + 1, result + numbers[index], target, numbers);
        DFS(index + 1, result - numbers[index], target, numbers);
    }

    public int solution(int[] numbers, int target) {
        DFS(0, 0, target, numbers);

        return count;
    }
}