import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())

    heights = []
    height_list = []
    for i in range(n):
        l, h = map(int, sys.stdin.readline().strip().split())
        heights.append([l, h])
        height_list.append(h)

    maximum_height = max(height_list)

    maximum_indexes = []
    for height in heights:
        if height[1] == maximum_height:
            maximum_indexes.append(height[0])

    heights = sorted(heights, key=lambda x: x[0])

    area = 0
    area += (max(maximum_indexes) - min(maximum_indexes) + 1) * maximum_height

    tmp_max = heights[0][1]
    prev_idx = 0
    for i in range(n):
        if heights[i][1] > tmp_max:
            area += tmp_max * (heights[i][0] - heights[prev_idx][0])
            prev_idx = i
            tmp_max = heights[i][1]
        if tmp_max == maximum_height:
            break

    tmp_max = heights[-1][1]
    prev_idx = n - 1
    for i in range(n - 1, -1, -1):
        if heights[i][1] > tmp_max:
            area += tmp_max * (heights[prev_idx][0] - heights[i][0])
            prev_idx = i
            tmp_max = heights[i][1]

        if tmp_max == maximum_height:
            break
    print(area)
