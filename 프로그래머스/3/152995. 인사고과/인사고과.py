def solution(scores):
    wanho = scores[0]
    wanho_work_score = wanho[0]
    wanho_company_score = wanho[1]
    
    sorted_scores = sorted(scores, key=lambda x: (-x[0], x[1]))

    
    max_company_score = 0
    rank = 0
    for score in sorted_scores:
        if wanho_work_score < score[0] and wanho_company_score < score[1]:
            return -1


        if score[1] >= max_company_score:
            max_company_score = score[1]
            if score[0] + score[1] > wanho_work_score + wanho_company_score:
                rank += 1

        

    return rank + 1