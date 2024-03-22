import sys
from collections import deque


def check_set(set1, set2):
    lst1 = list(set1)
    lst2 = list(set2)
    lst1.sort()
    lst2.sort()
    for i in range(len(lst1)):
        if lst1[i] != lst2[i]:
            return False
    return True


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    board = {}
    visited = [False] * (n + 1)

    for i in range(n):
        board[i + 1] = int(sys.stdin.readline().strip())

    answer_list = []

    for i in range(n):
        if board[i + 1] == i + 1:
            visited[i + 1] = True
            answer_list.append(i + 1)


    for num in range(1, n + 1):
        queue = deque()
        queue.append(num)
        visited[num] = True
        set1 = set()
        set2 = set()

        while queue:
            cur = queue.popleft()
            next_num = board[cur]
            set1.add(cur)
            set2.add(next_num)
            if not visited[next_num]:
                queue.append(next_num)
                visited[next_num] = True

        if check_set(set1, set2):
            answer_list += list(set1)
        else:
            for i in list(set1):
                visited[i] = False

    answer_list = list(set(answer_list))
    answer_list.sort()
    print(len(answer_list))
    for num in answer_list:
        print(num)
