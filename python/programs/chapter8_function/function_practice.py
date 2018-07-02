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
			
