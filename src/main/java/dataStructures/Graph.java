package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private final int vertices;
    private final LinkedList<Integer>[] adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adj = new LinkedList[this.vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.BFS(2);
        graph.DFS(2);
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void DFS(int source) {
        boolean[] visited = new boolean[this.vertices];
        System.out.print("DFS: ");
        DFSUtil(source, visited);
        System.out.println();
    }

    private void DFSUtil(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        LinkedList<Integer> data = adj[source];
        for (int i = 0; i < data.size(); i++) {
            int vertex = data.get(i);
            if (!visited[vertex]) {
                DFSUtil(vertex, visited);
            }
        }
    }

    public void BFS(int source) {
        boolean[] visited = new boolean[this.vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");
            LinkedList<Integer> data = adj[source];
            for (int i = 0; i < data.size(); i++) {
                int v = data.get(i);
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();
    }
}
