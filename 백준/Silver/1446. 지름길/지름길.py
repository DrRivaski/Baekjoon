import sys

shortest_dict = {}
shortcut_dict = {}


def initialize_shortest_dict(length):
    for i in range(length + 1):
        shortest_dict[i] = i


def initialize_shortcut_dict(D, length):
    for i in range(D):
        start, end, distance = map(int, sys.stdin.readline().strip().split())
        if (start, end) not in shortcut_dict:
            shortcut_dict[(start, end)] = distance
        else:
            if shortcut_dict[(start, end)] > distance:
                shortcut_dict[(start, end)] = distance

    rmv_index_list = []
    for shortcut in shortcut_dict:
        if shortcut[1] > length:
            rmv_index_list.append(shortcut)

    for shortcut in rmv_index_list:
        del shortcut_dict[shortcut]


if __name__ == "__main__":
    # 각 지점별로 최단거리 구하기
    # 최단거리 구할 때마다 업데이트하기

    D, length = map(int, sys.stdin.readline().strip().split())
    initialize_shortest_dict(length)
    # print(shortest_dict)
    initialize_shortcut_dict(D, length)
    shortcut_dict = dict(sorted(shortcut_dict.items(), key=lambda x: x[0][1]))
    # print(shortcut_dict)

    for shortcut in shortcut_dict:
        startpoint = shortcut[0]
        endpoint = shortcut[1]
        distance = shortcut_dict[shortcut]
        if shortest_dict[endpoint] > shortest_dict[startpoint] + distance:
            shortest_dict[endpoint] = shortest_dict[startpoint] + shortcut_dict[shortcut]
            for i in range(endpoint + 1, length + 1):
                shortest_dict[i] = i - endpoint + shortest_dict[endpoint]
    # print(shortest_dict)
    print(shortest_dict[length])
