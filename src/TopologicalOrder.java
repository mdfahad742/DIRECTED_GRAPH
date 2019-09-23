import java.util.Collections;
import java.util.Stack;

public class TopologicalOrder {
    public boolean[] visited;
    Stack<Integer> s;
    TopologicalOrder(Digraph G) {
        visited = new boolean[G.V];
        s = new Stack<>();
        for (int v = 0; v < G.V; v++) {
            if (!visited[v])
                dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(G, w);
        }
        s.push(v);
    }

    public Iterable<Integer> reversePost() {
        Collections.reverse(s);
        return s;
    }

}
