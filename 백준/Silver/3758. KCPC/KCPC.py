import sys

apply_cnt = {}
apply_order = {}
team_score = {}
team_score_sum = {}
final_rank = {}


def initialize_apply_cnt(n):
    for i in range(1, n + 1):
        apply_cnt[i] = 0


def initialize_apply_order(n):
    for i in range(1, n + 1):
        apply_order[i] = 0


def initialize_team_score(n, k):
    for i in range(1, n + 1):
        for j in range(1, k + 1):
            team_score[(i, j)] = 0


def initialize_team_score_sum(n):
    for i in range(1, n + 1):
        team_score_sum[i] = 0


if __name__ == "__main__":
    test_case = int(sys.stdin.readline().strip())

    for _ in range(test_case):
        n, k, t, m = map(int, sys.stdin.readline().strip().split())
        apply_cnt = {}
        apply_order = {}
        team_score = {}
        team_score_sum = {}
        final_rank = {}
        initialize_apply_cnt(n)
        initialize_apply_order(n)
        initialize_team_score(n, k)
        initialize_team_score_sum(n)

        for i in range(m):
            team_id, problem_id, score = map(int, sys.stdin.readline().strip().split())
            apply_cnt[team_id] += 1  # 제출 횟수
            apply_order[team_id] = i  # 제출 순서, 높을수록 나중에 제출
            team_score[(team_id, problem_id)] = max(team_score[(team_id, problem_id)], score)  # 팀의 각 문제별 점수

        for i in range(1, n + 1):
            for j in range(1, k + 1):
                team_score_sum[i] += team_score[(i, j)]

        for i in range(1, n + 1):
            final_rank[i] = [team_score_sum[i], apply_cnt[i], apply_order[i]]
            
        sorted_dict = dict(sorted(final_rank.items(), key=lambda x: (-x[1][0], x[1][1], x[1][2])))
        
        rank = 0
        for idx in sorted_dict:
            rank += 1
            if idx == t:
                print(rank)
                break
