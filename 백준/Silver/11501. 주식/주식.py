import sys

if __name__ == "__main__":
    T = int(input())

    for i in range(T):
        day = int(sys.stdin.readline())
        stocks = sys.stdin.readline().strip().split()
        for j in range(len(stocks)):
            stocks[j] = int(stocks[j])
        stocks.reverse()
        tmp_max = stocks[0]
        result = 0
        for j in range(1, len(stocks)):
            if stocks[j] <= tmp_max:
                result += tmp_max - stocks[j]
            else:
                tmp_max = stocks[j]
        print(result)
