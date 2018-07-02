#第七章 用户输入
name = input("Hello, what's your name? ")
print(name)

#7-3 10的倍数
numb = int(input("Please input a number: "))
if numb % 10 == 0:
	print(str(numb) + " 是10的倍数")
else:
	print(str(numb) + " 不是10的倍数")	

#7-6 电影票
print("7-6 电影票")
age = 0;
numb = 0;
while numb <= 10:
	numb += 1
	age = int(input("How old are you?"))
	if age < 3:
		print("Free!")
	elif  age >=3 and age < 12:
		print("10 dollars")
	else:
		print("15 dollars")
		break
	
