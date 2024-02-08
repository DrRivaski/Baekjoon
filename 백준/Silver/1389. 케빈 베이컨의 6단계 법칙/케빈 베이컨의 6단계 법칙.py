import sys
from collections import deque

visited = {}
depth = {}
score = {}
Graph = {}


def initialize_visited(n):
    for i in range(1, n + 1):
        visited[i] = False


def initialize_depth(n):
    for i in range(1, n + 1):
        depth[i] = 0


def initialize_score(n):
    for i in range(1, n + 1):
        score[i] = 0


def initialize_graph(n, m):
    for i in range(1, n + 1):
        Graph[i] = [0 for i in range(n + 1)]

    for i in range(m):
        num1, num2 = map(int, sys.stdin.readline().strip().split())
        Graph[num1][num2] = 1
        Graph[num2][num1] = 1


def BFS(start, n):
    initialize_depth(n)
    initialize_visited(n)

    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        cur = queue.popleft()
        for i in range(1, n + 1):
            if Graph[cur][i] == 1 and not visited[i]:
                queue.append(i)
                visited[i] = True
                depth[i] = depth[cur] + 1

    result = 0
    for i in range(1, n + 1):
        result += depth[i]
    score[start] = result


if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())

    initialize_graph(n, m)
    initialize_score(n)

    for i in range(1, n + 1):
        BFS(i, n)
    score = dict(sorted(score.items(), key=lambda x: (x[1], x[0])))
    
    print(next(iter(score)))
