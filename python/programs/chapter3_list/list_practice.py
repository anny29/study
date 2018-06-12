# 3-1 3-2
names = ["Hui", "Lei", "Min", "Yi"];
for i in range(4):
    print("Hi " + names[i])

#3-4 
print("\n3-4")
guests = []
guests.append('Father')
guests.append('Mother')
guests.append('Wife')
guests.append('cusion')
for i in range(len(guests)):
	print('I love you, ' + guests[i])

#3-5
print('\n3-5')
print(guests[-1] + " is not here")
guests[-1] = "child"
for i in range(len(guests)):
	print('I love you, ' + guests[i])

#3-6 新增 修改
print("\n3-6")
print("more person")
guests.insert(0, "Ma Ma")
guests.insert(2, "Ba Ba")
guests.append("Ye Ye")
for i in range(len(guests)):
	print("Be Happy " + guests[i])

#3-7 删除
print("\n3-7")
print("only two left")
for i in range(0, len(guests) - 2):
	person = guests.pop()
	print("Sorry " + person)

for i in range(len(guests)):
	print("You are here: " + guests[i])

print("delete left")
print(guests)

for i in range(len(guests)):
	del guests[0]

print(guests)


