def make_pulse(n):
    pulse1 = [1]
    pulse2 = [-1]
    
    for i in range(1, n):
        pulse1.append(pulse1[i - 1] * -1)
        pulse2.append(pulse2[i - 1] * -1)
    
    return pulse1, pulse2

def make_pulse_sequence(pulse, sequence, n):
    pulse_sequence = []
    for i in range(n):
        pulse_sequence.append(pulse[i] * sequence[i])
    
    return pulse_sequence

def find_maximum(pulse_sequence, n):
    dp = [pulse_sequence[0]]
    for i in range(1, n):
        if pulse_sequence[i] > dp[i - 1] + pulse_sequence[i]:
            dp.append(pulse_sequence[i])
        else:
            dp.append(dp[i - 1] + pulse_sequence[i])
    return max(dp)

def solution(sequence):
    n = len(sequence)
    pulse1, pulse2 = make_pulse(n)
    
    pulse_sequence1 = make_pulse_sequence(pulse1, sequence, n)
    pulse_sequence2 = make_pulse_sequence(pulse2, sequence, n)
    
    maximum1 = find_maximum(pulse_sequence1, n)
    maximum2 = find_maximum(pulse_sequence2, n)
    
    return max(maximum1, maximum2)