#4-10 切片
numbs = list(range(1, 11))
print(numbs)
print(numbs[0:3])

middle = int(len(numbs) / 2)
print(middle)
print(numbs[middle])
print(numbs[(middle - 1) : (middle + 2)])

print(numbs[-3:])

#元组
food = ("apple", "orange", "banana", "cake", "noodle")
print(food)
#food[4] = "chickens"
food = ('beaf', 'pork', 'chicken')
for meat in food:
	print(meat)

