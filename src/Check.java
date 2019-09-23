import java.nio.channels.Pipe;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Check {
    public static void main(String[] args) throws Exception {
        Comparator<Pair> c = new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                if (pair.x.compareTo(t1.x) == 0)
                    return pair.y.compareTo(t1.y);
                else
                    return pair.x.compareTo(t1.x);
            }
        };
        Pair p1 = new Pair(3, 1);
        Pair p2 = new Pair(6, 1);
        Pair p3 = new Pair(6, 2);
        Pair p4 = new Pair(5, 1);
        Pair p5 = new Pair(3, 7);
        Pair p6 = new Pair(7, 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(p1);
        pq.add(p2);
        pq.add(p3);
        pq.add(p4);
        pq.add(p5);
        pq.add(p6);
        System.out.println(pq);
    }
}


class Pair implements Comparable<Pair> {
    Integer x;
    Integer y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return x + " " + y;
    }

    public int compareTo(Pair that) {
        return this.x.compareTo(that.x);
    }
}
class sortByX implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p1.x.compareTo(p2.x);
    }
}
