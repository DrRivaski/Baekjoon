import sys

if __name__ == "__main__":
    ab = sys.stdin.readline().strip()
    length = len(ab)
    a_cnt = ab.count("a")

    ab += ab[0:a_cnt - 1]

    min_val = 1001
    for i in range(length):
        start = i
        end = i + a_cnt
        tmp_str = ab[start:end]
        min_val = min(min_val, tmp_str.count("b"))

    print(min_val)