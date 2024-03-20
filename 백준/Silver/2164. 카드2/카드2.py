import sys
from collections import deque

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    cards = deque()

    for i in range(1, n + 1):
        cards.append(i)

    while len(cards) > 2:
        cards.popleft()
        first = cards.popleft()
        cards.append(first)

    if len(cards) == 2:
        cards.popleft()
    answer = cards.popleft()
    print(answer)
