import java.util.Stack;

public class DirectedCycle {
    int[] edgeTo;
    boolean[] visited;
    boolean[] onStack;
    Stack<Integer> cycle;

    DirectedCycle(Digraph G) {
        visited = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v] && cycle == null) {
                dfs(G, v);
            }
        }
    }

    public void dfs(Digraph G, int v) {
        onStack[v] = true;
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null)
                return;
            else if (!visited[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public void dfs1(Digraph G, int v) {
        Stack<Integer> s = new Stack<>();
        s.push(v);
        while (!s.isEmpty()) {
            v = s.pop();

            if (!visited[v]) {
                visited[v] = true;
                onStack[v] = true;
            }
            for (int w : G.adj(v)) {
                if (cycle != null)
                    return;

                else if (!visited[w]) {
                    s.push(w);
                    edgeTo[w] = v;
                }

                else if (onStack[w]) {
                    cycle = new Stack<Integer>();
                    for (int x = v; x != w; x = edgeTo[x]) {
                        cycle.push(x);
                    }
                    cycle.push(w);
                    cycle.push(v);
                }
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

}
