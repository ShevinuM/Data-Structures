'''

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

'''
def climbStairs(n: int) -> int:
    if n == 1:
        return 1
    var_a = 1
    var_b = 1
    count = n-2
    while count >= 0:
        var_c = var_a + var_b
        var_a = var_b
        var_b = var_c
        count-=1
    return var_b