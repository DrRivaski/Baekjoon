from collections import deque

def solution(storey):
#     answer = 0
#     floor = [0 for i in range(100000001)]
#     visited = [False for i in range(100000001)]
#     direction = [-10000, -1000, -100, -10, -1, 1, 10, 100, 1000, 10000]
    
#     queue = deque()
#     queue.append(storey)
#     visited[storey] = True
#     while queue:
#         cur = queue.popleft()
#         for i in range(10):
#             new_f = cur + direction[i]
#             if 100000000 >= new_f >= 0 and not visited[new_f]:
#                 visited[new_f] = True
#                 queue.append(new_f)
#                 floor[new_f] = floor[cur] + 1
#                 if new_f == 0:
#                     return floor[new_f]
    answer = 0
    answer_list = []
    queue = deque()
    queue.append([storey, 0])
    
    while queue:
        cur = queue.popleft()
        cur_num = cur[0]
        cur_cnt = cur[1]
        remainder = cur_num % 10
        
        if remainder > 5:
            new_num = int((cur_num + 10 - remainder) / 10)
            queue.append([new_num, cur_cnt + 10 - remainder])
        elif remainder < 5:
            new_num = int((cur_num - remainder) / 10)
            if new_num == 0:
                answer_list.append([0, cur_cnt + remainder])
            else:
                queue.append([new_num, cur_cnt + remainder])
        else:
            new_num_up = int((cur_num + 5) / 10)
            new_num_down = int((cur_num - 5) / 10)
            queue.append([new_num_up, cur_cnt + 5])
            if new_num_down == 0:
                answer_list.append([0, cur_cnt + 5])
            else:
                queue.append([new_num_down, cur_cnt + 5])
    final_list = sorted(answer_list, key=lambda x: x[1])
    return final_list[0][1]
                
    