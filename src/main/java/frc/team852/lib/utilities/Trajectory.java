package frc.team852.lib.utilities;

import com.sun.istack.internal.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Trajectory<P extends IPose2D> implements Iterable<P>, JSONWritable {
    protected List<P> trajectory;

    @NotNull
    public boolean add(P p) {
        return trajectory.add(p);
    }

    public boolean addAll(Collection<? extends P> c) {
        return trajectory.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends P> c) {
        return trajectory.addAll(index, c);
    }

    public P get(int index) {
        return trajectory.get(index);
    }

    public int size() {
        return trajectory.size();
    }

    public boolean isEmpty() {
        return trajectory.isEmpty();
    }

    public Object[] toArray() {
        return trajectory.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return trajectory.toArray(a);
    }

    public Iterator<P> iterator() {
        return null;
    }

    public void forEach(Consumer<? super P> action) {
        trajectory.forEach(action);
    }



    @Override
    public String toJSON() {
        StringBuilder res = new StringBuilder("{\"type\": \"Trajectory\", \"trajectory\": [");
        this.forEach(p -> res.append(p.toJSON()).append(", "));
        return res.append("]}").toString();
    }
}
