import sys
import heapq


def initialize_graph(n):
    graph = [[] for i in range(n + 1)]
    return graph


def initialize_distance(n):
    distance = [float("inf")] * (n + 1)
    return distance


if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())
    graph = initialize_graph(n)
    for i in range(m):
        u, v, w = map(int, sys.stdin.readline().strip().split())
        graph[u].append((v, w))
        graph[v].append((u, w))

    distance = initialize_distance(n)

    start = 1
    queue = [(0, 1)]
    distance[start] = 0

    while queue:
        cur = heapq.heappop(queue)
        cur_dist = cur[0]
        cur_node = cur[1]

        if distance[cur_node] < cur_dist:
            continue

        # for 지우
        for node, dist in graph[cur_node]:
            if distance[node] > dist + distance[cur_node]:
                distance[node] = dist + distance[cur_node]
                heapq.heappush(queue, (distance[node], node))

    print(distance[n])
