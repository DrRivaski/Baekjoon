import sys


# 로봇 내리기
def unload_robot(robot_belt):
    if robot_belt[0][-1]:
        robot_belt[0][-1] = False


# 벨트 회전 (내구도 회전, 로봇 위치 회전)
def rotate_belt(belt, robot_belt, n):
    # 내구도 회전
    upper_belt = [0] + [belt[1][1]] + belt[0][1:n]
    lower_belt = [0] + belt[1][2:] + [belt[0][n]]
    belt[0] = upper_belt
    belt[1] = lower_belt

    # 로봇 회전
    upper_robot_belt = [False] + [robot_belt[1][1]] + robot_belt[0][1:n]
    lower_robot_belt = [False] + robot_belt[1][2:] + [robot_belt[0][n]]
    robot_belt[0] = upper_robot_belt
    robot_belt[1] = lower_robot_belt

    # 로봇 내리기
    unload_robot(robot_belt)


# 로봇 이동 (로봇 위치 회전, 내구도 감소)
def move_robot(belt, robot_belt, n):
    robot_location = []
    for i in range(1, n + 1):
        if robot_belt[0][i]:
            robot_location.append(i)

    robot_location.reverse()

    for loc in robot_location:
        next_location = loc + 1
        if belt[0][next_location] > 0 and not robot_belt[0][next_location]:
            robot_belt[0][next_location] = True
            robot_belt[0][loc] = False
            belt[0][next_location] -= 1
            unload_robot(robot_belt)


# 로봇 올리기 (내구도 감소)
def load_robot(belt, robot_belt):
    if belt[0][1] > 0 and not robot_belt[0][1]:
        robot_belt[0][1] = True
        belt[0][1] -= 1


# 0 개수 세기
def count_zero(belt):
    length = len(belt[0])
    count = 0
    for i in range(2):
        for j in range(1, length):
            if belt[i][j] == 0:
                count += 1
    return count


# 벨트 2차원배열 만들기
def initialize_belt(n):
    belt = [[0], [0]]
    power = list(map(int, sys.stdin.readline().strip().split()))
    belt[0] += power[:int(len(power) / 2)]
    half = power[int(len(power) / 2):]
    half.reverse()
    belt[1] += half
    return belt


def initialize_robot_belt(n):
    robot_belt = [[False] * (n + 1) for i in range(2)]
    return robot_belt


if __name__ == "__main__":
    n, k = map(int, sys.stdin.readline().strip().split())
    belt = initialize_belt(n)
    robot_belt = initialize_robot_belt(n)

    level = 0
    while True:
        level += 1
        rotate_belt(belt, robot_belt, n)
        move_robot(belt, robot_belt, n)
        load_robot(belt, robot_belt)
        if count_zero(belt) >= k:
            print(level)
            break
