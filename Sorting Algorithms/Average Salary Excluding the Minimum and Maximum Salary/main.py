# Time Complexity O(n)
def average(self, salary):
    """
    :type salary: List[int]
    :rtype: float
    """
    sum = 0.0
    max_value = max(salary)
    min_value = min(salary)
    salary.remove(max_value)
    salary.remove(min_value)
    for value in salary:
        sum = sum + value
    average = sum / len(salary)
    return average 