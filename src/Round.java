public class Round {
    private int round;

    public Round() {
        this.round = 0;
    }

    public int getRound() {
        return round;
    }

    public void tickRound() {
        this.round = this.round + 1;
    }
}
