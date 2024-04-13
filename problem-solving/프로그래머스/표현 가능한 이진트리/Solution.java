class Solution {

    private int countDummy(int height, String numberStr) {
        int fullNode = (int)Math.pow(2, height);

        return fullNode - numberStr.length();
    }

    private String makeFullTree(String numberStr) {
        int height = (int)(Math.log(numberStr.length()) / Math.log(2)) + 1;
        int dummy = countDummy(height, numberStr);
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < dummy; i++) {
            builder.append("0");
        }

        builder.append(numberStr);

        return builder.toString();
    }

    private int checkTree(String tree) {
        int result = 1;
        int middle = tree.length()/2;
        char root = tree.charAt(middle);

        if(root == '0') {
            if(Long.parseLong(tree, 2) != 0) result = 0;
        }

        if(tree.length() > 3) {
            String left = tree.substring(0, middle);
            String right = tree.substring(middle + 1);

            result = Math.min(result, checkTree(left));
            result = Math.min(result, checkTree(right));
        }

        return result;
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            String numberStr = Long.toString(number, 2);
            String fullTree = makeFullTree(numberStr);

            answer[i] = checkTree(fullTree);
        }

        return answer;
    }
}