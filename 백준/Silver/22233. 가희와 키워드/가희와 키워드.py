import sys

keywords = {}

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())
    for i in range(n):
        word = sys.stdin.readline().rstrip()
        keywords[word] = False

    cnt = n
    for i in range(m):
        written = sys.stdin.readline().rstrip().split(",")
        for w in written:
            if w in keywords:
                if not keywords[w]:
                    keywords[w] = True
                    cnt -= 1
        print(cnt)
