def max_value_with_extra_item(N, W, H, items):
    dp = [0] + [-float('inf')] * W
    
    for weight, value in items:
        for j in range(W, weight - 1, -1):
            dp[j] = max(dp[j], dp[j - weight] + value)
    
    max_value = max(dp)
    
    for weight, value in items:
        if weight <= H:
            for j in range(W - weight + 1):
                max_value = max(max_value, dp[j] + value)
    
    return max_value

# Example usage:
N = 5
W = 10
H = 2
items = [(2, 5), (1, 9 ), (4, 6)]
print(max_value_with_extra_item(N, W, H, items))
