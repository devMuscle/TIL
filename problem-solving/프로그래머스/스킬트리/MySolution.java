class Solution {

    public boolean sameSequence(String bible, String newSkill) {
        if(newSkill.equals(bible.substring(0, newSkill.length()))) return true;

        return false;
    }

    public int solution(String bible, String[] skillTrees) {
        int count = 0;

        for(String skillTree : skillTrees) {
            StringBuilder builder = new StringBuilder();

            for(String skill : skillTree.split("")) {
                if(bible.contains(skill)) {
                    builder.append(skill);
                }
            }

            if(sameSequence(bible, builder.toString())) {
                count++;
                System.out.println(builder.toString());
            }
        }

        return count;
    }
}