import sys

if __name__ == "__main__":
    num = sys.stdin.readline().strip()
    length = len(num)

    i = 0
    cur = 0
    while i < length:
        cur += 1
        for j in range(len(str(cur))):
            if i < length:
                if num[i] == str(cur)[j]:
                    i += 1
    print(cur)
