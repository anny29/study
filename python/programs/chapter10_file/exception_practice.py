## 异常练习 10-7
while(True):
	input_msg = input("请输入一个数字:")
	try:
		input_number = int(input_msg)
		print("你输入的数字是:" + input_msg)
	except ValueError :
		print("你输入的不是一个数字: " + input_msg)
	except TypeError:
		print("输入的信息无法转化为数字: " + input_msg)
		
