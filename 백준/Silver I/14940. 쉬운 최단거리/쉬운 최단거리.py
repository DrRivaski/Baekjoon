import sys
from collections import deque

graph = {}
distance_graph = {}
visited = {}
dir_x = [1, 0, -1, 0]
dir_y = [0, 1, 0, -1]


def initialize_graph(n, m):
    for i in range(n):
        graph[i] = sys.stdin.readline().strip().split()

    for i in range(n):
        for j in range(m):
            graph[i][j] = int(graph[i][j])


def initialize_distance_graph(n, m):
    for i in range(n):
        distance_graph[i] = [-1 for j in range(m)]

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                distance_graph[i][j] = 0
            if graph[i][j] == 2:
                distance_graph[i][j] = 0


def initialize_visited(n, m):
    for i in range(n):
        visited[i] = [False for j in range(m)]


def print_graph():
    for i in graph:
        print(graph[i])


def print_distance_graph():
    for i in distance_graph:
        for dist in distance_graph[i]:
            print(dist, end=" ")
        print()


def print_visited():
    for i in visited:
        print(visited[i])


def BFS(n, m):
    start_x = 0
    start_y = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                start_x = i
                start_y = j
                break

    queue = deque()
    queue.append((start_x, start_y))
    visited[start_x][start_y] = True
    while queue:
        current_pos = queue.popleft()
        cur_x = current_pos[0]
        cur_y = current_pos[1]
        for i in range(4):
            new_x = cur_x + dir_x[i]
            new_y = cur_y + dir_y[i]
            if -1 < new_x < n and -1 < new_y < m and not visited[new_x][new_y] and graph[new_x][new_y] != 0:
                queue.append((new_x, new_y))
                visited[new_x][new_y] = True
                distance_graph[new_x][new_y] = distance_graph[cur_x][cur_y] + 1


if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())

    initialize_graph(n, m)
    initialize_distance_graph(n, m)
    initialize_visited(n, m)
    # print_graph()
    # print_distance_graph()
    # print_visited()

    BFS(n, m)
    print_distance_graph()
