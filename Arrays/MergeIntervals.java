/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example:
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * Make sure the returned intervals are sorted.
 * 
**/

public class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        Integer startTime = new Integer(i1.start);
        Integer start = new Integer(i2.start);
        return startTime.compareTo(start);
    }
}

public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new IntervalComparator());

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(i + 1);

            if (first.start <= second.start && first.end >= second.end) {
                // Discard second
                intervals.remove(i + 1);
                i--;
            }

            if (second.start < first.end && first.end < second.end) {
                // Discard second and add it to first
                Interval temp = new Interval();
                temp.start = first.start;
                temp.end = second.end;
                intervals.remove(i + 1);
                intervals.set(i, temp);
                i--;
            }
            
        }
        
        return intervals;

    }
}