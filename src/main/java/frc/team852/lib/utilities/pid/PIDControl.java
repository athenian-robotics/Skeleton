package frc.team852.lib.utilities.pid;

/**
 * output = P × error + I × ∑error + D × error/t
 */

// TODO PID Filter
// TODO FeedForward fGain

public class PIDControl {

    private double pGain;
    private double iGain;
    private double dGain;
    private double fGain;

    private double maxI = 0;
    private double maxError = 0;

    // sum of past errors, the integral
    private double errorSum = 0;
    private double lastError = 0;

    private boolean hasBoundSet = false;
    private double upperBound;
    private double lowerBound;

    private boolean firstRun = true;
    private boolean reversed = false;

    private double lastReadingMilli = -1;
    private double readingTimeout = -1;

    private double output;


    public PIDControl(double p, double i, double d) {
        this.pGain = p;
        this.iGain = i;
        this.dGain = d;
        checkSigns();
    }

    public PIDControl(double p, double i, double d, double f) {
        this.pGain = p;
        this.iGain = i;
        this.dGain = d;
        this.fGain = f;
        checkSigns();
    }

    public PIDControl() {
        this.pGain = 0;
        this.iGain = 0;
        this.dGain = 0;
        this.fGain = 0;
    }

    // proportion
    public void setP(double p) {
        this.pGain = p;
        checkSigns();
        this.reset();
    }

    // integral for steady state error
    public void setI(double i) {
        this.iGain = i;
        checkSigns();
        this.reset();
    }

    // derivatives stabilizes, adds drag and sometimes push
    public void setD(double d) {
        this.dGain = d;
        checkSigns();
        this.reset();
    }

    // feed forward param, predict rough future output before pid respond
    // target speed and target acceleration multiplied by velocity and acceleration
    // only use in rough output value, never use in position based control modes
    public void setF(double f) {
        fGain = f;
        this.reset();
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

    private void reset() {
        this.errorSum = 0;
        this.lastReadingMilli = System.currentTimeMillis();
    }

    /**
     * To operate correctly, all PID parameters require the same sign
     * This should align with the {@literal}reversed value
     */
    private void checkSigns() {
        if (reversed) {
            if (pGain > 0) pGain *= -1;
            if (iGain > 0) iGain *= -1;
            if (dGain > 0) dGain *= -1;
            if (fGain > 0) fGain *= -1;
        } else {  // all values should be above zero
            if (pGain < 0) pGain *= -1;
            if (iGain < 0) iGain *= -1;
            if (dGain < 0) dGain *= -1;
            if (fGain < 0) fGain *= -1;
        }
    }


    private double constrain(double input, double lowerBound, double upperBound) {
        if (input > upperBound) return upperBound;
        else if (input < lowerBound) return lowerBound;
        else return input;
    }

    /**
     * PID output based on a passed in error and existing system state
     */
    public double getPID(double actual, double target) {

        double error = target - actual;

        // Reset if the last time we called this was greater than a certain time threshold
        if (this.readingTimeout > 0 && (System.currentTimeMillis() - this.lastReadingMilli) / 1000d > this.readingTimeout)
            this.reset();

        // delta time
        double dt = (System.currentTimeMillis() - this.lastReadingMilli) / 1000d;

        // rough F output, only depend on target location
        // todo probably doesnt work :(
        double fOut = this.fGain * target;

        // proportion
        double pOut = this.pGain * error;

        // accumulated sum multiplied the gain being passed in
        // also check if integral maxed out
        double iOut = this.iGain * this.errorSum;
        if (maxI != 0) iOut = constrain(iOut, -this.maxI, this.maxI);

        // derivative, rate of change times the gain, it's negative as it needs to decrease the error
        // set negative dGain in tuning
        double dOut = ((error - lastError) / dt) * dGain;

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


    public double getpGain() {
        return pGain;
    }

    public double getiGain() {
        return iGain;
    }

    public double getdGain() {
        return dGain;
    }

    private double constrainedOutput() {
        return this.output;
    }

    public String toString() {
        return String.format("P: %s, I: %s, D: %s", this.pGain, this.iGain, this.dGain);
    }

}
