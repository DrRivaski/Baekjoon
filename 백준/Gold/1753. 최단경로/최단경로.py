import sys
import heapq


def initialize_graph(n, e):
    # tmp_graph = [[float("inf")] * (n + 1) for i in range(n + 1)]
    # for i in range(e):
    #     u, v, w = map(int, sys.stdin.readline().strip().split())
    #     tmp_graph[u][v] = min(tmp_graph[u][v], w)

    graph = [[] for i in range(n + 1)]

    for i in range(e):
        u, v, w = map(int, sys.stdin.readline().strip().split())
        graph[u].append((v, w))

    # for i in range(1, n + 1):
    #     for j in range(1, n + 1):
    #         graph[i].append((j, tmp_graph[i][j]))

    return graph


def dijkstra(start, n, graph):
    distance = [float("inf")] * (n + 1)
    distance[start] = 0
    queue = [(0, start)]

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

    for i in range(1, n + 1):
        if distance[i] != float("inf"):
            print(distance[i])
        else:
            print("INF")


if __name__ == "__main__":
    n, e = map(int, sys.stdin.readline().strip().split())
    start = int(sys.stdin.readline().strip())
    graph = initialize_graph(n, e)
    dijkstra(start, n, graph)
