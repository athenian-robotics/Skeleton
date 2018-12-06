package frc.team852.lib.purepursuit;

public interface PoseQueue {
    public int size();
    public boolean isEmpty();
    public boolean add();

    // if queue is empty, returns null, or else retrieves and remove position
    public TrajectoryPosition remove();
    public void clear();
    public String toString();

}
