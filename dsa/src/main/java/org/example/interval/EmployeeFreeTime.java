package org.example.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public static List<int[]> employeeFreetime(List<List<int[]>> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            return new ArrayList<>();
        }

        List<int[]> merged = new ArrayList<>();
        for (List<int[]> intervals : schedule) {
            if (intervals != null) {
                merged.addAll(intervals);
            }
        }

        if (merged.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(merged, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int prevEnd = merged.get(0)[1];

        for (int i = 1; i < merged.size(); i++) {
            int[] curr = merged.get(i);

            if (curr[0] > prevEnd) {
                res.add(new int[]{prevEnd, curr[0]});
            }

            prevEnd = Math.max(prevEnd, curr[1]);
        }

        return res;
    }

    static void main() {
        List<List<int[]>> schedule = new ArrayList<>();

        schedule.add(Arrays.asList(new int[]{1, 2}, new int[]{5, 6}));
        schedule.add(Arrays.asList(new int[]{1, 3}));
        schedule.add(Arrays.asList(new int[]{4, 10}));

        List<int[]> result = employeeFreetime(schedule);

        // Print output

        System.out.println("Employee Free Time:");

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
