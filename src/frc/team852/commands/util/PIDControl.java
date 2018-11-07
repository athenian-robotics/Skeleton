package frc.team852.commands.util;

public class PIDControl {

    private double pGain;
    private double iGain;
    private double dGain;

    private double errorSum = 0;

    public PIDControl(double p, double i, double d) {
        this.pGain = p;
        this.iGain = i;
        this.dGain = d;
    }

    public PIDControl() {
        this.pGain = 0;
        this.iGain = 0;
        this.dGain = 0;
    }

    public void setP(double p) {
        this.pGain = p;
        this.reset();
    }

    public void setI(double i) {
        this.iGain = i;
        this.reset();
    }

    public void setD(double d) {
        this.dGain = d;
        this.reset();
    }

    private void reset() {
        this.errorSum = 0;
    }

    public double getpGain() { return pGain;}

    public double getiGain() { return iGain;}

    public double getdGain() { return dGain; }

    public String toString() { return String.format("P: %s, I: %s, D: %s", this.pGain, this.iGain, this.dGain); }

}
