if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        n = int(input())
        p = [0, 1, 1, 1, 2, 2]
        for j in range(6, n + 1):
            p.append(p[j - 1] + p[j - 5])
        print(p[n])
