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

print('\n3-5')
print(guests[-1] + " is not here")
guests[-1] = "child"
for i in range(len(guests)):
	print('I love you, ' + guests[i])


