package striverSDEsheet.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Djikstra {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        int[] ans = shortestPath(0, adj, n);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Time Complexity: O((N+E)*logN). Going through N nodes and E edges and log N
     * for priority queue
     * 
     * Space Complexity: O(N). Distance array and priority queue
     */
    private static int[] shortestPath(int s, ArrayList<ArrayList<Node>> adj, int n) {
        int dist[] = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = 100000000;
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(n, new Node());
        pq.offer(new Node(s, 0));
        while (pq.size() != 0) {
            Node node = pq.poll();
            for (Node it : adj.get(node.getV())) {
                if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {

                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.offer(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparator<Node> {
        private int v;
        private int weight;

        Node(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        Node() {
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.weight < node2.weight)
                return -1;
            if (node1.weight > node2.weight)
                return 1;
            return 0;
        }
    }
}
