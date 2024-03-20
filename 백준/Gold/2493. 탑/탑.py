import sys
from collections import deque

# tops = {}
# visited = {}
# answer = {}
#
#
# def initialize_tops(n):
#     top_list = sys.stdin.readline().strip().split()
#     for i in range(n):
#         tops[i + 1] = int(top_list[i])
#
#
# def initialize_visited(n):
#     for i in range(n):
#         visited[i + 1] = False
#
#
# def initialize_answer(n):
#     for i in range(n):
#         answer[i + 1] = 0
#
#
# def print_answer():
#     for ans in answer:
#         sys.stdout.write(str(answer[ans]))
#         sys.stdout.write(" ")
#
#
# def BFS(n, start):
#     cur_index = start
#     queue = deque()
#     queue.append(cur_index)
#
#     while queue:
#         cur_index = queue.popleft()
#         cur_height = tops[cur_index]
#         next_index = cur_index + 1
#         tmp_max_height = 0
#         for i in range(next_index, n + 1):
#             if cur_height >= tops[i] > tmp_max_height and not visited[i]:
#                 queue.append(i)
#                 visited[i] = True
#                 answer[i] = cur_index
#                 tmp_max_height = tops[i]
#             if tops[i] > cur_height:
#                 break
#
#
# if __name__ == "__main__":
#     n = int(sys.stdin.readline().strip())
#     initialize_tops(n)
#     initialize_visited(n)
#     initialize_answer(n)
#     for i in range(1, n + 1):
#         if not visited[i]:
#             BFS(n, i)
#
#     print_answer()

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    tops = [1000000000]
    tops += list(map(int, sys.stdin.readline().strip().split()))
    stack = deque()

    answer_list = [0] * (n + 1)

    # [number, height]
    stack.append([n, tops[n]])

    for i in range(n - 1, -1, -1):
        cur_height = tops[i]

        while True:
            if len(stack) == 0:
                break

            top = stack[-1]
            top_number = top[0]
            top_height = top[1]
            if cur_height > top_height:
                answer_list[top_number] = i
                stack.pop()
            else:
                stack.append([i, cur_height])
                break
        stack.append([i, cur_height])

    for num in answer_list[1:]:
        print(num, end=" ")
