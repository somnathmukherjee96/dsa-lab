package org.example.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    //intervals = [[0,30],[5,10],[15,20]]
    //Output: 2

    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0])
                minHeap.poll();

            minHeap.offer(interval[1]);
        }

        return minHeap.size();
    }

    static void main() {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        int meetingRooms = minMeetingRooms(intervals);

        System.out.println(meetingRooms);
    }
}
