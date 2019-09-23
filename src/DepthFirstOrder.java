import java.util.*;

public class DepthFirstOrder {
    boolean[] visited;
    int[] pre;
    int[] post;
    ArrayList<Integer> preorder;
    ArrayList<Integer> postorder;
    int preCounter;
    int postCounter;

    public DepthFirstOrder(Digraph G) {
        visited = new boolean[G.V];
        pre = new int[G.V];
        post = new int[G.V];
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();
        preCounter = 0;
        postCounter = 0;
        for (int v = 0; v < G.V; v++) {
            if (!visited[v]) {
                dfs(G, v);
            }
        }
    }

    public void dfs1(Digraph G, int v) {
        visited[v] = true;
        preorder.add(v);
        pre[v] = preCounter++;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(G, w);
            }
        }
        postorder.add(v);
        post[v] = postCounter++;
    }

    public void dfs(Digraph G, int s) {
        Stack<Integer> q = new Stack<>();
        q.push(s);
        while (!q.isEmpty()) {
            int v = q.pop();
            if (!visited[v]) {
                visited[v] = true;
                preorder.add(v);
                pre[v] = preCounter++;
            }
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    q.push(w);
                }
            }
            postorder.add(v);
            post[v] = postCounter++;
        }
    }

    public int pre(int v) {
        return pre[v];
    }

    public int post(int v) {
        return post[v];
    }

    public Iterable<Integer> post() {
        return postorder;
    }

    public Iterable<Integer> pre() {
        return preorder;
    }

    public Iterable<Integer> reversePost() {
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int v : postorder)
            reverse.add(v);
        Collections.reverse(reverse);
        return reverse;
    }

}
