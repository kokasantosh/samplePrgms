package com.sample.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {
    LinkedList<Integer> adj[];
    int v;
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u) {
        adj[v].add(u);
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[v];

        Queue<Integer> q = new LinkedBlockingQueue<>();

        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            s = q.poll();

            System.out.println(s);

            Iterator<Integer> iterator = adj[s].iterator();

            while(iterator.hasNext()) {
                int n = iterator.next();
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public void dfs(int s) {
        boolean visited[] = new boolean[v];

        dfsUtil(s, visited);
    }

    private void dfsUtil(int s, boolean[] visited) {
        visited[s] = true;
        List<Integer> list = adj[s];
        System.out.println(s);
        for(int element: list) {
            if(!visited[element]) {
                dfsUtil(element, visited);
            }
        }
    }

    public int countPath(int s, int d) {
        int pathCount = 0;

        return countPathUtil(s, d, pathCount);
    }

    private int countPathUtil(int s, int d, int pathCount) {
        if(s == d) {
            pathCount ++;
        } else {
            List<Integer> list = adj[s];
            for(int element: list) {
                pathCount = countPathUtil(element, d, pathCount);
            }
        }
        return pathCount;
    }
}
