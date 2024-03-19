import sys
import heapq
from collections import deque

def solution(n, roads, sources, destination):
    answer = []
    graph = {}
    for i in range(1, n + 1):
        graph[i] = []
    
    for road in roads:
        graph[road[0]].append(road[1])
        graph[road[1]].append(road[0])
    
    visited = [False for i in range(n + 1)]
    distance = [-1 for i in range(n + 1)]
    queue = deque()
    
    start = destination
    visited[start] = True
    distance[start] = 0
    queue.append(start)
    
    while queue:
        cur = queue.popleft()
        for dst in graph[cur]:
            if not visited[dst]:
                queue.append(dst)
                visited[dst] = True
                distance[dst] = distance[cur] + 1
                
    for source in sources:
        answer.append(distance[source])
    
    return answer