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

class IceCreamStand(Restaurant):
	def __init__(self, restaurant_name, cuisine_type, flavors):
		super().__init__(restaurant_name, cuisine_type)
		self.flavors = flavors[:]
	
	def describe_flavors(self):
		for flavor in self.flavors:
			print(flavor)

flavors = ["巧克力冰淇淋", "奶油冰淇淋"]
iceCream_restarunt =  IceCreamStand("冰淇淋店", "冰淇淋", flavors)
iceCream_restarunt.describe_restaurant()
iceCream_restarunt.describe_flavors()

class User():
	def __init__(self, first_name, last_name):
		self.first_name = first_name
		self.last_name = last_name
	
	def describe_user(self):
		print("用户的名称, first_name: " + self.first_name + ", last_name: " + self.last_name)
	
	def greet_user(self):
		print("Hello " + self.first_name.title() + " " + self.last_name.title())

class Privileges():
	def __init__(self, privileges):
		self.privileges = privileges[:]
	
	def show_privileges(self):
		print(self.privileges)	

class Admin(User):
	def __init__(self, first_name, last_name, privileges):
		super().__init__(first_name, last_name)
		self.privileges = Privileges(privileges)

print("\n9-8")
privileges = ["新增", "修改", "管理"]
admin = Admin("Lee", "Anny",  privileges)
admin.describe_user()
admin.privileges.show_privileges()
