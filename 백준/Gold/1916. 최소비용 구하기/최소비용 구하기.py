import sys
import heapq


def initialize_graph(n, m):
    tmp_graph = [[float("inf")] * (n + 1) for i in range(n + 1)]
    for i in range(m):
        start, dest, cost = map(int, sys.stdin.readline().strip().split())
        tmp_graph[start][dest] = min(tmp_graph[start][dest], cost)

    graph = {}
    for i in range(1, n + 1):
        graph[i] = []

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if tmp_graph[i][j] != float("inf"):
                graph[i].append((j, tmp_graph[i][j]))
    return graph


def initialize_distance(n):
    return [float("inf")] * (n + 1)


def dijkstra(start, destination, distance, graph):
    queue = [(0, start)]
    distance[start] = 0

    while queue:
        cur = heapq.heappop(queue)
        cur_dist = cur[0]
        cur_node = cur[1]

        if distance[cur_node] < cur_dist:
            continue

        for node, dist in graph[cur_node]:
            if distance[node] > distance[cur_node] + dist:
                distance[node] = distance[cur_node] + dist
                heapq.heappush(queue, (distance[node], node))
    print(distance[destination])


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    m = int(sys.stdin.readline().strip())
    graph = initialize_graph(n, m)
    distance = initialize_distance(n)
    start, destination = map(int, sys.stdin.readline().strip().split())
    dijkstra(start, destination, distance, graph)
