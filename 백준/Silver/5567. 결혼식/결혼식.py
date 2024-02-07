import sys
from collections import deque

friend_dict = {}
visited = {}

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    m = int(sys.stdin.readline().strip())

    # 친구 딕셔너리 초기화
    # adjacent list 이용
    for i in range(n + 1):
        friend_dict[i] = []
        visited[i] = 0
    for i in range(m):
        idx, friend = map(int, sys.stdin.readline().strip().split())
        friend_dict[idx].append(friend)
        friend_dict[friend].append(idx)

    if 1 not in friend_dict:
        print(0)
    else:
        q = deque()
        q.append(1)
        visited[1] = 1
        while q:
            cur = q.popleft()
            cur_list = friend_dict[cur]
            for friend in cur_list:
                if visited[friend] == 0:
                    q.append(friend)
                    visited[friend] = visited[cur] + 1

    answer = 0
    for friend in visited:
        if 2 <= visited[friend] <= 3:
            answer += 1
    print(answer)
