package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_081_082_083 {

    static long pathSum2() {
        int[][] matrix = getMatrix("p081_matrix.txt", 80);
        return dijkstra(matrix, 0, 2)[6400-1];
    }
    
    static long pathSum3() {
        int[][] matrix = getMatrix("p082_matrix.txt", 80);
        ArrayList<Long> paths = new ArrayList<Long>();
        
        for (int i = 0; i < 6400; i += 80) {
            long[] d = dijkstra(matrix, i, 3);
            for (int j = 79; j < 6400; j += 80) {
                paths.add(d[j]);
            }
        }
        
        return Collections.min(paths);
    }
    
    static long pathSum4() {
        int[][] matrix = getMatrix("p083_matrix.txt", 80);
        return dijkstra(matrix, 0, 4)[6400-1];
    }
    
    private static long[] dijkstra(int[][] graph, int src, int type) {
        int size = graph.length;
        PriorityQueue<long[]> minheap = new PriorityQueue<long[]>((a, b) -> (int) (a[1] - b[1]));
        long[] d = new long[size*size];
        int[] parent = new int[size*size];

        // initialize distances
        for (int i = 0; i < d.length; i++) {
            d[i] = Long.MAX_VALUE;
            parent[i] = -1;
        }
        d[src] = graph[src/size][src%size];
        long[] s = { src, d[src] };
        minheap.offer(s);
        
        while (!minheap.isEmpty()) {
            long[] u = minheap.poll();
            ArrayList<long[]> neighbors = getNeighbors(graph, u, type);
            for (long[] v : neighbors) {
                long alt = d[(int) u[0]] + v[1];
                if (alt < d[(int) v[0]]) {
                    d[(int) v[0]] = alt;
                    parent[(int) v[0]] = (int) u[0];
                    if (!minheap.contains(v)) {
                        v[1] = alt;
                        minheap.offer(v);
                    }
                }
            }
        }

        return d;
    }
    
    private static ArrayList<long[]> getNeighbors(int[][] g, long[] v, int num) {
        ArrayList<long[]> neighbors = new ArrayList<long[]>();
        int size = g.length;
        
        // right neighbor 
        if (v[0]/size == (v[0]+1)/size && v[0]+1 < size*size) { 
            long[] right = { v[0]+1, g[(int) ((v[0]+1)/size)][(int) ((v[0]+1)%size)] };
            neighbors.add(right);
        }
        // down neighbor
        if (v[0]+size < size*size) {
            long[] down = { v[0]+size, g[(int) ((v[0]/size) + 1)][(int) ((v[0]+size)%size)] };
            neighbors.add(down);
        }
        if(num > 2) {
            // up neighbor
            if (v[0]-size > 0) {
                long[] up = { v[0]-size, g[(int) ((v[0]/size) - 1)][(int) ((v[0]-size)%size)] };
                neighbors.add(up);
            }
            if (num == 4) {
                // left neighbor
                if (v[0]/size == (v[0]-1)/size && v[0]-1 > 0) { 
                    long[] right = { v[0]-1, g[(int) ((v[0]-1)/size)][(int) ((v[0]-1)%size)] };
                    neighbors.add(right);
                }
            }
        }
        
        return neighbors;
    }
    
    private static int[][] getMatrix(String fileName, int size) {
        int[][] matrix = new int[size][size];
        String line = "";
        int row = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((line = reader.readLine()) != null) {
                int col = 0;
                for (String num : line.split(",")) {
                    matrix[row][col++] = Integer.parseInt(num);
                }
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return matrix;
    }
}
