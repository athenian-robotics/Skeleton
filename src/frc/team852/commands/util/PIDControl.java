package frc.team852.commands.util;

/**
 * output = P × error + I × ∑error + D × error/t
 */

public class PIDControl {

    private double pGain;
    private double iGain;
    private double dGain;

    private double maxI = 0;
    private double maxError = 0;

    // sum of past errors, the integral
    private double errorSum = 0;
    private double lastError = 0;

    private boolean hasBoundSet = false;
    private double upperBound;
    private double lowerBound;

    private boolean reversed = false;

    private double lastReadingMilli = -1;
    private double readingTimeout = -1;

    private double output;


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
        this.lastReadingMilli = System.currentTimeMillis();
    }

    /**
     * Reverse the value in case the error changes in case the values are changing reversed
     * Will NOT allow for reversing while running
     */
    public void setReversed() {
        if (reversed) {
            pGain *= -1;
            iGain *= -1;
            dGain *= -1;
        }
    }

    /**
     * Set a threshold for what is considered a timeout
     */
    public void setReadingTimeout(float milliseconds) {
        this.readingTimeout = milliseconds;
    }

    /**
     * cap for integral maximum
     */
    public void setMaxI(double maximum) {
        this.maxI = maximum;
        if (this.iGain != 0) this.maxError = this.maxI / this.iGain;
    }

    /**
     * set a constraint on output, don't want motor controllers to go bonkers
     */
    public void setOutputConstraints(double mininum, double maximum) {
        this.lowerBound = mininum;
        this.upperBound = maximum;
        this.hasBoundSet = true;
    }

    private double constrain(double input, double lowerBound, double upperBound) {
        if (input > upperBound) return upperBound;
        else if (input < lowerBound) return lowerBound;
        else return input;
    }

    /**
     * PID output based on a passed in error and existing system state
     */
    public double getPID(double error) {
        // Reset if the last time we called this was greater than a certain time threshold
        if (this.readingTimeout > 0 && (System.currentTimeMillis() - this.lastReadingMilli) / 1000d > this.readingTimeout)
            this.reset();

        // delta time
        double dt = (System.currentTimeMillis() - this.lastReadingMilli) / 1000d;

        // proportion
        double pOut = this.pGain * error;

        // accumulated sum multiplied the gain being passed in
        // also check if integral maxed out
        double iOut = this.iGain * this.errorSum ;
        if (maxI != 0) iOut = constrain(iOut, -this.maxI, this.maxI);

        // derivative, rate of change times the gain, it's negative as it needs to decrease the error
        // set negative dGain in tuning
        double dOut = ((error - lastError) / dt )* dGain;

        //reset error
        this.lastError = error;

        // final values
        output = pOut + iOut + dOut;

        // check for bound
        if (this.hasBoundSet) output = constrain(output, this.lowerBound, this.upperBound);

        // updating constraints
        if (maxI != 0)
            // set boundary so it doesn't go bonkers
            this.errorSum = constrain(this.errorSum + error, -this.maxError, this.maxError) * dt;
        else
            // increase sum for integral
            this.errorSum += error * dt;

        this.lastReadingMilli = System.currentTimeMillis();

        // reeeeeeeeeeeeeeeeeeeeeeeeeeeee
        return output;
    }


    public double getpGain() { return pGain; }

    public double getiGain() { return iGain; }

    public double getdGain() { return dGain; }

    private double constrainedOutput() { return this.output; }

    public String toString() { return String.format("P: %s, I: %s, D: %s", this.pGain, this.iGain, this.dGain); }

}
