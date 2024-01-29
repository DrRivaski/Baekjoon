import sys

input = sys.stdin.readline


def find_heart(arr, n):
    for i in range(n):
        for j in range(n):
            if arr[i][j] != "_":
                return [i + 2, j + 1]


def calculate_left_arm(arr, heart):
    length = 0
    heart_x = heart[0] - 1  # 2
    heart_y = heart[1] - 1  # 2

    # 2, 1부터 아래로 내려가면서 count
    for i in range(heart_y - 1, -1, -1):
        if arr[heart_x][i] != "*":
            break
        else:
            length += 1
    return length


def calculate_right_arm(arr, heart):
    length = 0
    heart_x = heart[0] - 1
    heart_y = heart[1] - 1
    for i in range(heart_y + 1, len(arr)):
        if arr[heart_x][i] != "*":
            break
        else:
            length += 1
    return length


def calculate_body(arr, heart):
    length = 0
    heart_x = heart[0] - 1
    heart_y = heart[1] - 1
    body_x = 0
    body_y = 0
    for i in range(heart_x + 1, len(arr)):
        if arr[i][heart_y] != "*":
            body_x = i - 1
            body_y = heart_y
            break
        else:
            length += 1
    return length, [body_x, body_y]


def calculate_left_leg(arr, body):
    length = 0
    leg_x = body[0] + 1
    leg_y = body[1] - 1
    for i in range(leg_x, len(arr)):
        if arr[i][leg_y] != "*":
            break
        else:
            length += 1
    return length

def calculate_right_leg(arr, body):
    length = 0
    leg_x = body[0] + 1
    leg_y = body[1] + 1
    for i in range(leg_x, len(arr)):
        if arr[i][leg_y] != "*":
            break
        else:
            length += 1
    return length


if __name__ == "__main__":
    n = int(input())
    a = []
    for i in range(n):
        a.append(list(input().strip()))

    heart = find_heart(a, n)
    print(heart[0], end=" ")
    print(heart[1])

    left_arm_length = calculate_left_arm(a, heart)
    right_arm_length = calculate_right_arm(a, heart)
    print(left_arm_length, end=" ")
    print(right_arm_length, end=" ")

    body_length, body = calculate_body(a, heart)
    print(body_length, end=" ")
    left_leg_length = calculate_left_leg(a, body)
    right_leg_length = calculate_right_leg(a, body)

    print(left_leg_length, end=" ")
    print(right_leg_length)
