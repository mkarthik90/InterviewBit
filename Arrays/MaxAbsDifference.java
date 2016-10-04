/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 * For example,
 * A=[1, 3, -1]
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 * So, we return 5.
 */
class MaximumAbsDifference {
    public int maxArr(ArrayList<Integer> A) {
        List<Sortt> l = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            l.add(new Sortt(A.get(i), i + 1));
        }

        Collections.sort(l);
        Sortt second = l.get(l.size() - 1);
        Sortt first = l.get(0);
        
        int maximumDiff = Math.abs(first.a - second.a) + Math.abs(first.index - second.index);
        
        Collections.sort(l, new SortComparator());
        first = l.get(0);
        second = l.get(l.size() - 1);
        
        int secondDiff = Math.abs(first.a - second.a) + Math.abs(first.index - second.index);
            
        return maximumDiff > secondDiff ? maximumDiff : secondDiff;

    }

    class Sortt implements Comparable<Sortt> {
        public Integer a;
        public int index;

        public Sortt(Integer a, int index) {
            this.a = a;
            this.index = index;
        }

        public int compareTo(Sortt s) {
            Integer first = this.a + this.index;
            Integer secod = s.a + s.index;
            return first.compareTo(secod);
        }

    }
    
    class SortComparator implements Comparator<Sortt> {
        public int compare(Sortt s1, Sortt s2) {
            Integer first = s1.a - s1.index;
            Integer second = s2.a - s2.index;
            return first.compareTo(second);
        }
    }
}