import sys

input = sys.stdin.readline

if __name__ == "__main__":
    cntDict = {}
    N, M = map(int, input().split())
    for i in range(N):
        word = input().strip()
        if len(word) >= M:
            if word in cntDict:
                cntDict[word] += 1
            else:
                cntDict[word] = 1

    # print(cntDict)
    voca = sorted(cntDict.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))
    # print(cntDict)

    for word in voca:
        print(word[0])
