dp = {}
answer_dict = {}
def initialize_dp(n, sequence):
    dp[-1] = 0
    dp[0] = sequence[0]
    
    for i in range(1, n):
        dp[i] = dp[i - 1] + sequence[i]

def find_index(n, k):
    for i in range(n):
        if dp[i] >= k:
            return i

def solution(sequence, k):
    if k in sequence:
        return [sequence.index(k), sequence.index(k)]
    answer = []
    length = len(sequence)
    initialize_dp(length, sequence)
    
    right = find_index(length, k)
    left = 0
    current = dp[right]
    
    while right < length:
        if current > k:
            while left < right:
                current -= sequence[left]
                left += 1
                if current <= k:
                    break
        
        if current == k:
            answer_dict[(left, right)] = [left, right - left + 1]
        
        right += 1
        if right < length:
            current += sequence[right]
        
    answer_dict2 = dict(sorted(answer_dict.items(), key=lambda x: (x[1][1], x[1][0])))
    answer_index = list(answer_dict2.keys())[0]
    answer.append(answer_index[0])
    answer.append(answer_index[1])
    return answer