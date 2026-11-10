/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> ins) {
        ins.sort((a, b) -> a.start - b.start);
        var minHeap = new PriorityQueue<Integer>();

        for (Interval in : ins) {
            if(!minHeap.isEmpty() && in.start >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.offer(in.end);
        }

        return minHeap.size();
    }
}
