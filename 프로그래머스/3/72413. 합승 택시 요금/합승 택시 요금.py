from collections import deque

def initialize_graph(fares, n):
    graph = {}
    for i in range(1, n + 1):
        graph[i] = []
    
    for fare in fares:
        graph[fare[0]].append((fare[1], fare[2]))
        graph[fare[1]].append((fare[0], fare[2]))
    
    return graph


def dijkstra(graph, s, distance):
    distance[s] = 0
    queue = deque()
    queue.append((0, s))
    
    while queue:
        cur = queue.popleft()
        cur_distance = cur[0]
        cur_node = cur[1]
        
        if distance[cur_node] < cur_distance:
            continue
        
        for node, cost in graph[cur_node]:
            if distance[node] > distance[cur_node] + cost:
                distance[node] = distance[cur_node] + cost
                queue.append((distance[node], node))
    
    

def solution(n, s, a, b, fares):
    distance_together = [100000000] * (n + 1)
    distance_a = [100000000] * (n + 1)
    distance_b = [100000000] * (n + 1)
    
    graph = initialize_graph(fares, n)
    
    dijkstra(graph, s, distance_together)
    dijkstra(graph, a, distance_a)
    dijkstra(graph, b, distance_b)
    
    minimum = float("inf")
    for i in range(1, n + 1):
        if minimum > distance_together[i] + distance_a[i] + distance_b[i]:
            minimum = distance_together[i] + distance_a[i] + distance_b[i]
    
    return minimum