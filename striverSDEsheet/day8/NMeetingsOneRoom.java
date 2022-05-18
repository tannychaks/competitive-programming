package striverSDEsheet.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingsOneRoom {

    static class Meeting {
        int start;
        int end;
        int pos;

        Meeting() {
        }

        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        int[] start = new int[] { 1, 3, 0, 5, 8, 5 };
        int[] end = new int[] { 2, 4, 6, 7, 9, 9 };

        int n = 6;

        int max = maxMeetings(start, end, n);

        System.out.println(max);
    }

    private static int maxMeetings(int[] start, int[] end, int n) {

        List<Meeting> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            meet.add(new Meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meet, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.end < m2.end)
                    return -1;
                else if (m1.end > m2.end)
                    return 1;
                else if (m1.pos < m2.pos)
                    return -1;
                return 1;
            }
        });

        // meet.stream()
        // .forEach(meeting ->System.out.print(meeting.start + " "
        // + meeting.end + " " + meeting.pos + " \n" ) );

        List<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }

        // for(int i = 0;i<ans.size(); i++) {
        // System.out.print(ans.get(i) + " ");
        // }
        // System.out.println();
        return ans.size();
    }
}
