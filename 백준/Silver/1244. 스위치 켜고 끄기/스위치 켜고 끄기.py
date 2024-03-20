import sys


def male_convert_switches(switches, n, qty):
    i = 1
    while True:
        index = i * n
        if index > qty:
            break
        if switches[index] == 1:
            switches[index] = 0
        else:
            switches[index] = 1
        i += 1


def female_convert_switches(switches, n, qty):
    if switches[n] == 1:
        switches[n] = 0
    else:
        switches[n] = 1
    left = n - 1
    right = n + 1
    while left > 0 and right <= qty:
        if switches[left] == switches[right]:
            if switches[left] == 1:
                switches[left] = 0
            else:
                switches[left] = 1

            if switches[right] == 1:
                switches[right] = 0
            else:
                switches[right] = 1
        else:
            break
        left -= 1
        right += 1


if __name__ == "__main__":
    switch_qty = int(sys.stdin.readline().strip())
    switches = [0]
    switches += list(map(int, sys.stdin.readline().strip().split()))

    student_num = int(sys.stdin.readline().strip())

    for i in range(student_num):
        gender, n = map(int, sys.stdin.readline().strip().split())
        if gender == 1:
            male_convert_switches(switches, n, switch_qty)
        else:
            female_convert_switches(switches, n, switch_qty)

    num_rows = int(switch_qty / 20) + 1
    for i in range(num_rows):
        for switch in switches[20 * i + 1: 20 * (i + 1) + 1]:
            print(switch, end=" ")
        if i + 1 < num_rows:
            print("")
