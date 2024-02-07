import sys

# 가능한 set 구하기, dict에 저장 (), len
# dict를 len으로 정렬
# maxlen보다 작은 set 삭제
# set중에 c가 포함되지 않은 set의 len print

if __name__ == "__main__":
    n, d, k, c = map(int, input().split())
    sushi_list = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
    for i in range(k):
        sushi_list.append(sushi_list[i])

    maxsize = 0
    for i in range(n):
        tmp_set2 = set(sushi_list[i:i + k] + [c])
        maxsize = max(maxsize, len(tmp_set2))
    print(maxsize)
