import sys
import bisect

# 칭호를 나타내기 위한 dictionary
class_dict = {}

powers = []

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())

    for i in range(n):
        tmp_class = sys.stdin.readline().strip().split()
        class_dict[i] = tmp_class[0]
        powers.append(int(tmp_class[1]))

    for i in range(m):
        power = int(sys.stdin.readline().strip())
        sys.stdout.write(class_dict[bisect.bisect_left(powers, power)] + "\n")
