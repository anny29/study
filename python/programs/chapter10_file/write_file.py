## 10-4 写入文件
file_name = "guests_book.txt"
with open(file_name, "a") as file_object:
	while(True):
		input_guset = input("Please input your name, input q to quit:")
		if input_guset == "q":
			break
		else:
			print("Welcome " + input_guset)
			file_object.write(input_guset + "\n")


