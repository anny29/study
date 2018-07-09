#9-2 三家餐馆 9-4 就餐人数
class Restaurant():
	
	def __init__(self, restaurant_name, cuisine_type):
		self.restaurant_name = restaurant_name
		self.cuisine_type = cuisine_type
		self.number_served = 0
	
	def describe_restaurant(self):
		print("Restaurant: " + self.restaurant_name + " is " + self.cuisine_type + ", served " + str(self.number_served))
	
	def open_restaurant(self):
		print(self.restaurant_name + " is open!")
	
	def set_number_served(self, number):
		self.number_served = number
	
	def increment_number_served(self, increment):
		self.number_served += increment
		

noodle_rest = Restaurant("重庆小面", "面馆")
noodle_rest.describe_restaurant()
noodle_rest.open_restaurant()
noodle_rest.set_number_served(20)
noodle_rest.describe_restaurant()
noodle_rest.increment_number_served(10)
noodle_rest.describe_restaurant()

