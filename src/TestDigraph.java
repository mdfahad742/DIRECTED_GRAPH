import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TestDigraph {
    public static void main(String[] args)throws IOException {
        //Scanner sc = new Scanner(System.in);
//        Digraph G = new Digraph(13);
////        G.addEdge(0, 5);
////        G.addEdge(0, 2);
////        G.addEdge(0, 1);
////        G.addEdge(3, 6);
////        G.addEdge(3, 5);
////        G.addEdge(3, 4);
////        G.addEdge(5, 2);
////        G.addEdge(6, 4);
////        G.addEdge(6, 0);
////        G.addEdge(3, 2);
////        G.addEdge(1, 4);
//
//
////        G.addEdge(0, 1);
////        G.addEdge(1, 4);
////        G.addEdge(1, 3);
////        G.addEdge(2, 4);
////        G.addEdge(1, 2);
//
//
//        G.addEdge(4, 2);
//        G.addEdge(2, 3);
//        G.addEdge(3, 2);
//        G.addEdge(6, 0);
//        G.addEdge(0, 1);
//        G.addEdge(2, 0);
//        G.addEdge(11, 12);
//        G.addEdge(12, 9);
//        G.addEdge(9, 10);
//        G.addEdge(9, 11);
//        G.addEdge(7, 9);
//        G.addEdge(10, 12);
//        G.addEdge(11, 4);
//        G.addEdge(4, 3);
//        G.addEdge(3, 5);
//        G.addEdge(6, 8);
//        G.addEdge(8, 6);
//        G.addEdge(5, 4);
//        G.addEdge(0, 5);
//        G.addEdge(6, 4);
//        G.addEdge(6, 9);
//        G.addEdge(7, 6);
//
//
//
////        G.addEdge(0, 1);
////        G.addEdge(0, 2);
////        G.addEdge(1, 3);
////        G.addEdge(4, 1);
////        G.addEdge(6, 4);
////        G.addEdge(5, 6);
////        G.addEdge(5, 2);
////        G.addEdge(6, 0);
//
//        System.out.println(G);
//        int s = 0;
//        DirectedDFS path1 = new DirectedDFS(G, s);
//        System.out.println("DFS");
//        for (int v = 0; v < G.V; v++) {
//            if (path1.hasPathTo(v)) {
//                System.out.printf("%d to %d\n", s, v); // all vertices connected to s
//                System.out.println(path1.pathTo(v));
//                System.out.println();
//            }
//            else System.out.printf("%d to %d not connected\n", s, v);
//        }
//        System.out.println();
//        System.out.println("BFS");
//        DirectedBFS path2 = new DirectedBFS(G, s);
//        for (int v = 0; v < G.V; v++) {
//            if (path2.hasPathTo(v)) {
//                System.out.printf("%d to %d\n", s, v); // all vertices connected to s
//                System.out.printf("%d is the distance from %d to %d\n", path2.distTo(v), s, v);
//                System.out.println(path2.pathTo(v));
//                System.out.println();
//            }
//            else System.out.printf("%d to %d not connected\n", s, v);
//        }
//        System.out.println();
//        DepthFirstOrder order = new DepthFirstOrder(G);
//        System.out.println(order.reversePost());
//        //System.out.println(order.post());
//        //System.out.println(order.pre());
//        KosarajuSharirSCC ssc = new KosarajuSharirSCC(G);
//        System.out.println(Arrays.toString(ssc.id));
//        System.out.println(ssc.lenSCC);
        Scanner sc = new Scanner(new File("/home/fahad/Downloads/SCC.txt"));
        Digraph G = new Digraph(875714);
        while (sc.hasNextInt()) {
            int v = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
            G.addEdge(v, w);
        }
        KosarajuSharirSCC ssc = new KosarajuSharirSCC(G);
        ArrayList<Integer> len = ssc.len;
        Collections.sort(len, Collections.reverseOrder());
        //System.out.println("ans");
        System.out.println(len.get(0) + "," + len.get(1) + "," + len.get(2) + "," + len.get(3) + "," + len.get(4));

    }
}
