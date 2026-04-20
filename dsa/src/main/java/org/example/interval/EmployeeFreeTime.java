package org.example.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public static List<int[]> employeeFreetime(List<List<int[]>> schedule) {
        List<int[]> merged = new ArrayList<>();

        for (List<int[]> intervals : schedule)
            merged.addAll(intervals);

        Collections.sort(merged, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int[] prev = merged.getFirst();

        for (int i = 1; i < merged.size(); i++) {
            int[] curr = merged.get(i);

            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(new int[]{prev[1], curr[0]});
                prev = curr;
            }
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
