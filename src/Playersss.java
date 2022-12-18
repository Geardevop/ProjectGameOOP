public class Playersss {

    public int max = 6, min = 1, range = max - min + 1;

    private String Myname;
    private int MyCountRound;
    private int CurrentPoint = 0, BeforePoint = 0;

    public Playersss() {
        this.Myname = "";
        this.min = 1;
    }

    public Playersss(int Order) {

        this.Myname = "Player" + Order + "";
        this.MyCountRound = 0;
        CurrentPoint = 0;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getMyname() {
        return Myname;
    }

    public void setMyname(String myname) {
        Myname = myname;
    }

    public int getMyCountRound() {
        return MyCountRound;
    }

    public void setMyCountRound(int myCountRound) {
        MyCountRound += myCountRound;
    }
    public int getCurrentPoint() {
        return CurrentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        CurrentPoint = currentPoint;
    }

    public int getBeforePoint() {
        return BeforePoint;
    }

    public void setBeforePoint(int beforePoint) {
        BeforePoint = beforePoint;
    }
}