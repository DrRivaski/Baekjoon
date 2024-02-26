import sys
import heapq


def initialize_graph(n, e):
    graph = {}
    for i in range(1, n + 1):
        graph[i] = []

    for i in range(e):
        u, v, w = map(int, sys.stdin.readline().strip().split())
        graph[u].append((v, w))
        graph[v].append((u, w))

    return graph


def initialize_distance(n):
    return [float("inf")] * (n + 1)


def dijkstra(start, destination, n, graph):
    distance = initialize_distance(n)

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

    return distance[destination]


if __name__ == "__main__":
    n, e = map(int, sys.stdin.readline().strip().split())
    graph = initialize_graph(n, e)
    v1, v2 = map(int, sys.stdin.readline().strip().split())
    answer1 = dijkstra(1, v1, n, graph) + dijkstra(v1, v2, n, graph) + dijkstra(v2, n, n, graph)
    answer2 = dijkstra(1, v2, n, graph) + dijkstra(v2, v1, n, graph) + dijkstra(v1, n, n, graph)

    answer = min(answer1, answer2)

    if answer == float("inf"):
        print(-1)
    else:
        print(answer)
