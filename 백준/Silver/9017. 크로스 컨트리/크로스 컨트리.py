import sys

if __name__ == "__main__":
    T = int(sys.stdin.readline().strip())
    for _ in range(T):
        n = int(sys.stdin.readline().strip())
        team = list(map(int, sys.stdin.readline().strip().split()))
        tmpRemove = []

        # 팀원이 6명이 아닌 팀 찾기
        for i in range(len(team)):
            if team.count(team[i]) != 6:
                tmpRemove.append(team[i])

        # 팀원이 6명이 아닌 팀 제거하기
        for i in range(len(tmpRemove)):
            team.remove(tmpRemove[i])

        # 점수표 만들기
        score = [i + 1 for i in range(len(team))]

        # 4등까지 더한 점수 dictionary 만들기
        score_dict = {}
        for i in team:
            score_dict[i] = [0, float("inf")]

        score_cnt_dict = {}
        for i in team:
            score_cnt_dict[i] = 0

        for i in range(len(team)):
            cur_team = team[i]
            if score_cnt_dict[cur_team] < 4:
                score_dict[cur_team][0] += score[i]
                score_cnt_dict[cur_team] += 1
            elif score_cnt_dict[cur_team] == 4:
                score_dict[cur_team][1] = i
                score_cnt_dict[cur_team] += 1

        score_dict = dict(sorted(score_dict.items(), key=lambda x: (x[1][0], x[1][1])))
        print(list(score_dict.keys())[0])
