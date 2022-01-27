package com.interview.graph.others;

import java.util.PriorityQueue;
	
public class CheapestFlightsWithinKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] g = new int[n][n];
		for (int[] f : flights) {
			g[f[0]][f[1]] = f[2];
		}

		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		heap.offer(new int[] { 0, src, K + 1 });

		while (!heap.isEmpty()) {
			int[] cur = heap.poll();
			int price = cur[0], place = cur[1], remainStops = cur[2];

			if (place == dst)
				return price;

			if (remainStops > 0) {
				for (int i = 0; i < n; i++) {
					if (g[place][i] > 0) {
						heap.offer(new int[] { price + g[place][i], i, remainStops - 1 });
					}
				}
			}
		}

		return -1;
	}

}