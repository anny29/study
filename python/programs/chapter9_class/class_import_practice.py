from random import randint

from class_practice import Restaurant

my_restarunt = Restaurant("东北小炕桌", "东北菜")
my_restarunt.describe_restaurant()

class Die():
	def __init__(self, sides=6):
		self.sides = sides
	
	def roll_die(self):
		print(randint(1, self.sides))
	
	def roll_times(self, times):
		for i in range(1, times + 1):
			self.roll_die()

print("6边型扔十次")
six_sides = Die();
for i in range(1, 11):
	six_sides.roll_die()

print("10边型扔十次")
ten_sides = Die(10)
ten_sides.roll_times(10)

