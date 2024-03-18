import sys
from collections import deque

def convert_maps(maps):
    graph = []
    for map in maps:
        tmp_list = []
        for word in map:
            if word != 'X':
                tmp_list.append(int(word))
            else:
                tmp_list.append(-1)
        graph.append(tmp_list)
    return graph

def check_availability(graph):
    for i in graph:
        for j in i:
            if j != -1:
                return True
    return False
        

def solution(maps):
    answer = []
    graph = convert_maps(maps)
    if not check_availability(graph):
        return [-1]
    n = len(graph)
    m = len(graph[0])
    visited = [[False] * m for i in range(n)]
    
    dir_x = [1, 0, -1, 0]
    dir_y = [0, 1, 0, -1]
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] != -1 and not visited[i][j]:
                queue = deque()
                queue.append([i, j])
                visited[i][j] = True
                days = graph[i][j]
                
                while queue:
                    cur = queue.popleft()
                    cur_x = cur[0]
                    cur_y = cur[1]
                    
                    for k in range(4):
                        new_x = cur_x + dir_x[k]
                        new_y = cur_y + dir_y[k]
                        if 0 <= new_x < n and 0 <= new_y < m and not visited[new_x][new_y] and graph[new_x][new_y] != -1:
                            days += graph[new_x][new_y]
                            queue.append([new_x, new_y])
                            visited[new_x][new_y] = True
                answer.append(days)
    
    answer.sort()
    return answer