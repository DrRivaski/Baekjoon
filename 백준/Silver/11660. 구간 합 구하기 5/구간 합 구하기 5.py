import sys

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())

    matrix = [[0 for i in range(n + 1)]]
    for i in range(n):
        matrix.append([0])
    for i in range(1, n + 1):
        for num in list(map(int, sys.stdin.readline().strip().split())):
            matrix[i].append(num)

    dp_matrix = []
    for i in range(n + 1):
        tmp_list = []
        tmp_num = 0
        for num in matrix[i]:
            tmp_num += num
            tmp_list.append(tmp_num)
        dp_matrix.append(tmp_list)

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            dp_matrix[i][j] += dp_matrix[i - 1][j]

    for i in range(m):
        start_x, start_y, end_x, end_y = map(int, sys.stdin.readline().strip().split())
        answer = dp_matrix[end_x][end_y]
        answer -= dp_matrix[start_x - 1][end_y]
        answer -= dp_matrix[end_x][start_y - 1]
        answer += dp_matrix[start_x - 1][start_y - 1]
        print(answer)
