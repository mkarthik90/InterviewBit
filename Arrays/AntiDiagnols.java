/**
 * Finds the list of anti diagonals in matrix.
 * Check out this link: https://www.interviewbit.com/problems/anti-diagonals/
**/
class AntiDiagnols {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {

            ArrayList<Integer> row = a.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (i == 0 || j == row.size() - 1) {
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(row.get(j));
                    result.add(r);
                } else {
                    ArrayList<Integer> r = result.get(i + j);
                    r.add(row.get(j));
                    result.set(i + j, r);
                }
            }

        }

        return result;
    }
}