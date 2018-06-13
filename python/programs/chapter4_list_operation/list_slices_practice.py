#4-10 切片
numbs = list(range(1, 11))
print(numbs)
print(numbs[0:3])

middle = int(len(numbs) / 2)
print(middle)
print(numbs[middle])
print(numbs[(middle - 1) : (middle + 2)])

print(numbs[-3:])
