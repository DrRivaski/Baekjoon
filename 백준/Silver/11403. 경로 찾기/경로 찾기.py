import sys
from collections import deque

Graph = {}
visited = {}


def initialize_graph(n):
    for i in range(n + 1):
        Graph[i] = [0]

    for i in range(n):
        Graph[i + 1] += sys.stdin.readline().strip().split()

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            Graph[i][j] = int(Graph[i][j])


def initialize_visited(n):
    for i in range(n + 1):
        visited[i] = False


def DFS(start, n):
    initialize_visited(n)
    stack = deque()
    stack.appendleft(start)

    while stack:
        cur = stack.popleft()
        for i in range(1, n + 1):
            if Graph[cur][i] == 1 and not visited[i]:
                stack.appendleft(i)
                visited[i] = True

    for i in range(1, n + 1):
        if visited[i]:
            print(1, end=" ")
        else:
            print(0, end=" ")
    print()


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())

    initialize_graph(n)

    for i in range(1, n + 1):
        DFS(i, n)
