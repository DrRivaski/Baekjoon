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


def initialize_graph(n):
    for i in range(1, n + 1):
        Graph[i] = [0 for i in range(n + 1)]

    while True:
        num1, num2 = map(int, sys.stdin.readline().strip().split())
        if num1 == -1:
            break
        Graph[num1][num2] = 1
        Graph[num2][num1] = 1


def BFS(start, n):
    initialize_visited(n)
    initialize_depth(n)

    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        cur = queue.popleft()
        for i in range(1, n + 1):
            if Graph[cur][i] == 1 and not visited[i]:
                visited[i] = True
                queue.append(i)
                depth[i] = depth[cur] + 1

    sorted_depth = dict(sorted(depth.items(), key=lambda x: x[1], reverse=True))
    score[start] = sorted_depth[next(iter(sorted_depth))]


def find_answer(n):
    score_list = []
    for i in range(1, n + 1):
        score_list.append(score[i])

    min_score = min(score_list)
    print(min_score, end=" ")
    print(score_list.count(min_score))

    for i in range(1, n + 1):
        if score[i] == min_score:
            print(i, end=" ")


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    initialize_graph(n)
    initialize_score(n)

    for i in range(1, n + 1):
        BFS(i, n)

    find_answer(n)
