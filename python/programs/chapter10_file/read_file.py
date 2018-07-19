## 10-1 读取文件
file_name = "learning_python.txt";
with open(file_name) as file_object:
	contents = file_object.read()
	print(contents.rstrip())

print("\n逐行读取")
with open(file_name) as file_per_line:
	lines = file_per_line.readlines()

for line in lines:
	print(line.rstrip().replace('Python', 'Java'))
