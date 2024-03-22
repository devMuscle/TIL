class Solution {

    private char pushButton(char number, char left, char right, String hand) {
        switch(number) {
            case '1', '4', '7' -> {return 'L';}
            case '3', '6', '9' -> {return 'R';}
            case '2', '5', '8' ,'0' -> {
                int leftDistance = distance(position(number), position(left));
                int rightDistance = distance(position(number), position(right));

                if(leftDistance > rightDistance) {
                    return 'R';
                }else if(leftDistance < rightDistance) {
                    return 'L';
                }
            }
        }

        return hand.equals("left") ? 'L' : 'R';
    }

    private int distance(int[] positions1, int[] positions2) {
        return Math.abs(positions1[0] - positions2[0]) + Math.abs(positions1[1] - positions2[1]);
    }

    private int[] position(char number) {
        char[][] phone = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}, {'*', '0', '#'}};

        for(int i = 0; i < phone.length; i++) {
            for(int j = 0; j < phone[i].length; j++) {
                if(phone[i][j] == number) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {-1,-1};
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        char left = '*';
        char right = '#';

        for(int number : numbers) {
            char c = pushButton((char)(number + '0'), left, right, hand);
            switch(c) {
                case 'L' -> left = (char)(number + '0');
                case 'R' -> right = (char)(number + '0');
            }
            answer += c;
        }

        return answer;
    }
}