#import module_test
from module_test import print_test
#第八章 函数
#8-1 打印T-shirt
def make_shirt(msg = 'I love Python', size = 'L'):
	"""打印T-shirt信息"""
	print("The T-shirt' size is " + size + ", the words are '" + msg + "'." )

make_shirt();
make_shirt(size = 'M')
make_shirt("I'll forget Python")

#8-6 城市名
print("\n8-6 城市名")
def display_city(city_name, country):
	print(city_name.title() + ", " + country.title())

display_city("宜昌", "中国")	
display_city("巴黎", "法国")

#8-7 专辑
print("\n专辑")
def make_album(singer, album, songs_numb = 0):
	album_info = {"singer": singer, "album": album}
	if songs_numb != 0:
		album_info["songs_numb"] = songs_numb
	return album_info

while True:
	print("请输入歌手名和专辑名,输入q则退出:")
	singer = input("歌手名:")
	if "q" == singer:
		break
	
	album = input("专辑名:")
	if "q" == album:
		break
	
	album_info = make_album(singer, album)
	print(album_info)

#8-10 传递列表
print("\n8-10 传递列表")	
def make_great(magicians):
	for i in range(len(magicians)):
		magicians[i] = "the Great " + magicians[i]

def show_magicians(magicians):
	for magician in magicians:
		print(magician)

magicians = ['Liu Qian', 'David']
make_great(magicians)
show_magicians(magicians)

#8-12 任意数量参数
print("\n8-12 任意数量参数")
def make_car(manufacturer, model, **car_infos):
	car_info = {}
	car_info['manufacturer'] = manufacturer
	car_info['model'] = model
	for key, val in car_infos.items():
		car_info[key] = val
	return car_info

i8_info = make_car('bmw', 'i8', price='200w', color='white')
print(i8_info)

#8-17 导入其他模块函数
print("\n8-17 导入其他模块函数")
#module_test.print_test("导入其他模块函数")	
print_test("引入模块中的函数")		
