import sys

if __name__ == "__main__":
    length, K = map(int, sys.stdin.readline().split())
    table = sys.stdin.readline().strip()

    table_dict = {}
    for i in range(length):
        table_dict[i] = table[i]
    hamburger_visited_dict = {}
    hamburger_cnt = 0
    for i in range(length):
        if table_dict[i] == 'P':  # 사람인 경우
            start = i - K
            end = i + K + 1
            if start < 0:
                start = 0
            if end > length:
                end = length
            for j in range(start, end):
                if table_dict[j] == 'H' and j not in hamburger_visited_dict:
                    hamburger_visited_dict[j] = True
                    hamburger_cnt += 1
                    break

    print(hamburger_cnt)