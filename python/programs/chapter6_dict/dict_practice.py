#6-3 词汇表
print("6-3 词汇表")
dict_keys = {
	'if' : '判断',
	'elif': '其他判断',
	'else': '其他条件',
	'for': '循环',
	'del': '删除',
	}
print(dict_keys)
print('if: ' + dict_keys['if'])
print('elif: ' + dict_keys['elif'])
print('else: ' + dict_keys['else'])
print('for: ' + dict_keys['for'])
print('del: ' + dict_keys['del'])
print("循环遍历")
for key, val in dict_keys.items():
	print(key + ": " + val)

#6-6 调查
print("\n6-6 调查")
fav_lang = {
	'li': 'java',
	'cai': 'python',
	'yue': 'javascript',
	'chang': 'python',
	'ye': 'perl'
	}
persons = ['li', 'ye', 'cai', 'shen']
for person in persons:
	if person in fav_lang.keys():
		print("Thank you, " + person + ", your favorite language is " + fav_lang[person].title())
	else:
		print("Hello " + person + ", what's your favorite language?")

