import sys

input = sys.stdin.readline

if __name__ == "__main__":
    h, w = map(int, input().strip().split())

    height_list = input().strip().split()
    for i in range(w):
        height_list[i] = int(height_list[i])

    heights = {}
    for i in range(1, w + 1):
        heights[i] = height_list[i - 1]

    answer = 0

    for i in range(2, w):
        cur_height = heights[i]

        left_max_height = 0
        for j in range(i - 1, 0, -1):
            if heights[j] > cur_height and heights[j] > left_max_height:
                left_max_height = heights[j]

        right_max_height = 0
        for j in range(i + 1, w + 1):
            if heights[j] > cur_height and heights[j] > right_max_height:
                right_max_height = heights[j]

        if left_max_height != 0 and right_max_height != 0:
            answer += min(left_max_height, right_max_height) - cur_height

    print(answer)
