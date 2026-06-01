package org.example.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFreeTime {

    public static List<int[]> employeeFreeTime(List<List<int[]>> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            return new ArrayList<>();
        }

        List<int[]> res = new ArrayList<>();

        List<int[]> mergedIntervals = new ArrayList<>();

        for (List<int[]> emp : schedule) {
            mergedIntervals.addAll(emp);
        }

        mergedIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = mergedIntervals.getFirst();

        for (int i = 1; i < mergedIntervals.size(); i++) {
            int[] curr = mergedIntervals.get(i);

            if (prev[1] > curr[0]) {
                res.add(new int[]{prev[1], curr[0]});
                prev = curr;
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }

        return res;
    }

    static void main() {
        List<List<int[]>> schedule = new ArrayList<>();

        schedule.add(Arrays.asList(new int[]{1, 2}, new int[]{5, 6}));
        schedule.add(Arrays.asList(new int[]{1, 3}));
        schedule.add(Arrays.asList(new int[]{4, 10}));

        List<int[]> result = employeeFreeTime(schedule);

        // Print output

        System.out.println("Employee Free Time:");

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
