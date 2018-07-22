## 11-2

def format_city(city, country, population=0):
	""" 输出城市, 国家 - population 10000 格式"""
	formated_str = (city + ", " + country).title()
	if population:
		formated_str += " - population " + str(population) 
	
	return formated_str

