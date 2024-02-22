def calculate_power(mineral):
    result = []
    dia_power = 0
    for m in mineral:
        dia_power += 1
    result.append(dia_power)
    
    iron_power = 0
    for m in mineral:
        if m == "diamond":
            iron_power += 5
        else:
            iron_power += 1
    result.append(iron_power)
    
    stone_power = 0
    for m in mineral:
        if m == "diamond":
            stone_power += 25
        elif m == "iron":
            stone_power += 5
        else:
            stone_power += 1
    
    result.append(stone_power)
    return result

def solution(picks, minerals):
    answer = 0
    number_of_picks = picks[0] + picks[1] + picks[2]
    length = len(minerals)
    
    power_dict = {}
    
    if length >= 5 * number_of_picks:
        for i in range(number_of_picks):
            power_dict[i] = calculate_power(minerals[5 * i: 5 * (i + 1)])
    else:
        for i in range(int(length / 5)):
            power_dict[i] = calculate_power(minerals[5 * i: 5 * (i + 1)])
        power_dict[int(length / 5) + 1] = calculate_power(minerals[int(length / 5) * 5:])
        
    
    power_dict = dict(sorted(power_dict.items(), key=lambda x: (-x[1][2], -x[1][1], -x[1][0])))
    
    
    for p in power_dict:
        if picks[0] != 0:
            answer += power_dict[p][0]
            picks[0] -= 1
        elif picks[1] != 0:
            answer += power_dict[p][1]
            picks[1] -= 1
        else: 
            answer += power_dict[p][2]
            picks[2] -= 1
    
    return answer