class Solution {
    public String solution(int[] food) {
        StringBuilder builder = new StringBuilder();

        for(int i = 1; i < food.length; i++) {
            for(int count = 1; count <= food[i]/2; count++) {
                builder.append(Integer.toString(i));
            }
        }

        String reversed = new StringBuilder(builder).reverse().toString();
        builder.append('0');
        builder.append(reversed);

        return builder.toString();
    }
}