def twoSum(nums, target):
    l = len(nums)
    for i in range(l):
        for j in range(i + 1,l):
            if int(nums[i]) + int(nums[j]) == int(target):
                return [i,j]


if __name__ == '__main__':
    print(twoSum([3, 4, 3], 6))
