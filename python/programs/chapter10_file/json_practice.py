## json practice
import json

test_dict = {'aa': '123', 'bb': '234'}
#test_list = ['12', '34']
filename = 'test_dict.json'
with open(filename, 'w') as file_object:
	json.dump(test_dict, file_object)
	#json.dump(file_object, test_list)
