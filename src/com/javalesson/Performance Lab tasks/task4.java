import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class task4 {

    public static void main(String[] args) throws ParseException, IOException {

        task4[] intervals = new task4[6];

        intervals[0] = new task4(800, 830);
        intervals[1] = new task4(815, 845);
        intervals[2] = new task4(845, 900);
        intervals[3] = new task4(830, 900);
        intervals[4] = new task4(900, 930);
        intervals[5] = new task4(910, 920);

        for (int i = 0; i < intervals.length - 1; i++) {
            intervals[i].crossing(intervals[i + 1]);
        }
    }

    private int start, end;

    task4(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private int getStart() {
        return start;
    }

    private int getEnd() {
        return end;
    }

    void crossing(task4 inter) throws ParseException {
        int x = Math.max(start, inter.getStart());
        int y = Math.min(end, inter.getEnd());

        while (x < y) {
            String dateInString1 = String.valueOf(x);
            String dateInString2 = String.valueOf(y);

            SimpleDateFormat formatter = new SimpleDateFormat("Hmm");

            Date date1 = formatter.parse(dateInString1);
            Date date2 = formatter.parse(dateInString2);
            System.out.println(date1.getHours() + ":" + date1.getMinutes() + " " + date2.getHours() + ":" + date2.getMinutes());
            break;
        }
    }
}


