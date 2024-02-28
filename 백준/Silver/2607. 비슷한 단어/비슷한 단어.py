import sys

if __name__ == "__main__":
    answer = 0
    n = int(sys.stdin.readline().strip())
    word = sys.stdin.readline().strip()
    word_dict = {}
    alphabet = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"]
    for a in alphabet:
        word_dict[a] = 0

    for w in word:
        word_dict[w] += 1

    for i in range(n - 1):
        cur_word = sys.stdin.readline().strip()
        cur_word_dict = {}
        for a in alphabet:
            cur_word_dict[a] = 0
        for w in cur_word:
            cur_word_dict[w] += 1

        tmp_word_dict = {}
        for w in word_dict:
            tmp_word_dict[w] = cur_word_dict[w] - word_dict[w]

        l = []
        for w in tmp_word_dict:
            if tmp_word_dict[w] != 0:
                l.append(tmp_word_dict[w])
        if l == [1, -1] or l == [-1, 1] or l == [1] or l == [-1] or l == []:
            answer += 1

    print(answer)
