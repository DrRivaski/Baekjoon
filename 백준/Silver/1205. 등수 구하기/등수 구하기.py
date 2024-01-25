N, score, P = map(int, input().split(" "))

if N == 0:
    print(1)
else:
    scoreArr = [-1] * P
    tmpArr = input().split(" ")
    for i in range(N):
        scoreArr[i] = int(tmpArr[i])

    rank = -1

    for i in range(P):
        if score >= scoreArr[i]:
            rank = i + 1
            break
    if scoreArr[rank - 1] == scoreArr[-1] and score == scoreArr[-1]:
        rank = -1
    print(rank)
