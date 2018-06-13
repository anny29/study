#4-1 4-2 列表遍历
print("4-1 列表遍历")
pets = ['dog', 'cat', 'rabbit']
for pet in pets:
	print("A " + pet + " would make a great pet.")

print("Any of these animals would make a great pet!")	

#4-3 计算 1~1000000
print("\n4-3 计算 1~1000000")
numbs = list(range(1, 1000001))
print(min(numbs))
print(max(numbs))
print(sum(numbs))

#4-6 奇数
print("\n4-6 奇数列表")
odd_numbers = list(range(1, 21, 2))
print(odd_numbers)
for odd in odd_numbers:
    print(odd)

#4-7 3的倍数
print("\n4-7 3的倍数")    
numbs = list(range(3, 31, 3))
print(numbs)

#4-8 4-9 立方
print("\n4-8 立方")
cubes = []
for i in range(1, 11):
    cubes.append(i ** 3)
print(cubes) 

print("\n4-9 列表解析")
cubic_numbs = [value ** 3 for value in range(1, 11)]
print(cubic_numbs)


    
