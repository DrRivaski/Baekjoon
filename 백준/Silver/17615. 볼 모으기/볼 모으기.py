import sys


def find_right_different_index(balls_dict, N):
    right_side = balls_dict[N - 1]
    for i in range(N - 1, -1, -1):
        if balls_dict[i] != right_side:
            return i
    return -1


def find_left_different_index(balls_dict, N):
    left_side = balls_dict[0]
    for i in range(N):
        if balls_dict[i] != left_side:
            return i
    return N


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    balls = sys.stdin.readline().strip()
    balls_dict = {}
    i = 0
    for ball in balls:
        balls_dict[i] = ball
        i += 1

    maximum_counts = []

    # 양 끝의 색깔이 같을 경우
    if balls_dict[0] == balls_dict[N - 1]:

        # 가운데 공을 옮기는 경우의 수
        middle_cnt = 0
        side = balls_dict[0]
        for i in range(1, N):
            if balls_dict[i] != side:
                middle_cnt += 1

        # 왼쪽부터 옮기는 경우의 수
        left_cnt = 0
        right_index = find_right_different_index(balls_dict, N)
        for i in range(right_index):
            if balls_dict[i] == side:
                left_cnt += 1
        # 가장 오른쪽의 다른 공의 index 구하기

        # 오른쪽부터 옮기는 경우의 수
        right_cnt = 0
        left_index = find_left_different_index(balls_dict, N)
        for i in range(N - 1, left_index, -1):
            if balls_dict[i] == side:
                right_cnt += 1

        maximum_counts.append(middle_cnt)
        maximum_counts.append(left_cnt)
        maximum_counts.append(right_cnt)



    # 양 끝의 색깔이 다를 경우
    else:
        # 왼쪽부터 세기
        left_side = balls_dict[0]
        left_side_cnt = 0
        right_index = find_right_different_index(balls_dict, N)
        for i in range(right_index + 1):
            if balls_dict[i] == left_side:
                left_side_cnt += 1

        # 왼쪽부터 오른쪽거 세기
        right_side = balls_dict[N - 1]
        left_side_cnt2 = 0
        for i in range(right_index):
            if balls_dict[i] == right_side:
                left_side_cnt2 += 1

        # 오른쪽부터 세기
        left_index = find_left_different_index(balls_dict, N)
        right_side_cnt = 0
        for i in range(N - 1, left_index - 1, -1):
            if balls_dict[i] == right_side:
                right_side_cnt += 1

        # 오른쪽부터 왼쪽거 세기
        right_side_cnt2 = 0
        for i in range(N - 1, left_index, -1):
            if balls_dict[i] != right_side:
                right_side_cnt2 += 1

        maximum_counts.append(left_side_cnt)
        maximum_counts.append(left_side_cnt2)
        maximum_counts.append(right_side_cnt)
        maximum_counts.append(right_side_cnt2)

    print(min(maximum_counts))
