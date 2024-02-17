package Helpers;

public class Intervals {

    private int start;
    private int end;

    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Intervals() {};


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
