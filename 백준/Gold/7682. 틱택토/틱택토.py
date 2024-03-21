import sys


def count_x(board):
    cnt = 0
    for w in board:
        if w == 'X':
            cnt += 1
    return cnt


def count_o(board):
    cnt = 0
    for w in board:
        if w == 'O':
            cnt += 1
    return cnt


def check_winner(board, player):
    game_board = [board[0:3], board[3:6], board[6:]]
    win_line = player * 3
    if game_board[0] == win_line:
        return True
    if game_board[1] == win_line:
        return True
    if game_board[2] == win_line:
        return True

    if board[0] + board[3] + board[6] == win_line:
        return True
    if board[1] + board[4] + board[7] == win_line:
        return True
    if board[2] + board[5] + board[8] == win_line:
        return True

    if board[0] + board[4] + board[8] == win_line:
        return True
    if board[2] + board[4] + board[6] == win_line:
        return True

    return False


if __name__ == "__main__":
    while True:
        board = sys.stdin.readline().strip()
        if board == "end":
            break

        x_cnt = count_x(board)
        o_cnt = count_o(board)

        if o_cnt > x_cnt:
            sys.stdout.write("invalid\n")
            continue

        if x_cnt - o_cnt > 1:
            sys.stdout.write("invalid\n")
            continue

        x_win = check_winner(board, "X")
        o_win = check_winner(board, "O")

        if x_win:
            if o_win:
                sys.stdout.write("invalid\n")
                continue
            if x_cnt <= o_cnt:
                sys.stdout.write("invalid\n")
                continue

        if o_win:
            if x_cnt != o_cnt:
                sys.stdout.write("invalid\n")
                continue

        if not x_win and not o_win:
            if x_cnt + o_cnt < 9:
                sys.stdout.write("invalid\n")
                continue

        sys.stdout.write("valid\n")
