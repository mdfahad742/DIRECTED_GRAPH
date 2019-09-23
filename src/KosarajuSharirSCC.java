import java.util.ArrayList;
import java.util.Stack;

public class KosarajuSharirSCC {
    boolean visited[];
    int id[];
    int count;
    ArrayList<Integer> len;
    int lenSCC = 0;
    public KosarajuSharirSCC(Digraph G) {
        visited = new boolean[G.V()];
        id = new int[G.V()];
        len = new ArrayList<>();
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        //System.out.println("reverse " + order.reversePost());
        count = 0;
        for (int v : order.reversePost()) {
            if (!visited[v]) {
                lenSCC = 0;
                dfs(G, v);
                count++;
                len.add(lenSCC);
            }
        }
    }

    public void dfs1(Digraph G, int v) {
        lenSCC++;
        visited[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(G, w);
            }
        }
    }

    public void dfs(Digraph G, int s) {
        Stack<Integer> q = new Stack<>();
        q.push(s);
        while (!q.isEmpty()) {
            int v = q.pop();
            if (!visited[v]) {
                visited[v] = true;
                lenSCC++;
                id[v] = count;
            }
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    q.push(w);
                }
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
}
