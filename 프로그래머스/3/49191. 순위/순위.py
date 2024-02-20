from collections import deque

# 자신보다 강한 사람의 수를 세고, 약한 사람의 수를 세기
# 이 두 수의 합이 n-1이라면 순위 정할 수 있음

winning_graph = {}
losing_graph = {}
winning_cnt = {}
losing_cnt = {}
winning_visited = {}
losing_visited = {}

def initialize_winning_graph(n, results):
    for i in range(1, n + 1):
        winning_graph[i] = [0 for j in range(n + 1)]
    
    for result in results:
        winning_graph[result[0]][result[1]] = 1

def initialize_losing_graph(n, results):
    for i in range(1, n + 1):
        losing_graph[i] = [0 for j in range(n + 1)]
    
    for result in results:
        losing_graph[result[1]][result[0]] = 1

def initialize_cnt(n):
    for i in range(1, n + 1):
        winning_cnt[i] = 0
        losing_cnt[i] = 0

def initialize_visited(n):
    for i in range(1, n + 1):
        winning_visited[i] = False
        losing_visited[i] = False
        
def solution(n, results):
    initialize_winning_graph(n, results)
    initialize_losing_graph(n, results)
    initialize_cnt(n)
    
    print(winning_graph)
    print(losing_graph)
    
    
    for i in range(1, n + 1):
        initialize_visited(n)
    
        winning_queue = deque()
        winning_queue.append(i)
        winning_visited[i] = True
        
        while winning_queue:
            cur = winning_queue.popleft()
            for j in range(1, n + 1):
                if winning_graph[cur][j] == 1 and not winning_visited[j]:
                    winning_queue.append(j)
                    winning_visited[j] = True
                    winning_cnt[i] += 1
        
        losing_queue = deque()
        losing_queue.append(i)
        losing_visited[i] = True
        
        while losing_queue:
            cur = losing_queue.popleft()
            for j in range(1, n + 1):
                if losing_graph[cur][j] == 1 and not losing_visited[j]:
                    losing_queue.append(j)
                    losing_visited[j] = True
                    losing_cnt[i] += 1
        
    print(winning_cnt)
    print(losing_cnt)
    
    answer = 0
    for i in range(1, n + 1):
        if winning_cnt[i] + losing_cnt[i] == n - 1:
            answer += 1
    
    return answer