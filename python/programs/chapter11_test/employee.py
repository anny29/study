## 雇员类
class Employee():
	""" 雇员类"""
	def __init__(self, first_name, last_name, salary):
		""" 姓 名 和年薪属性"""
		self.first_name = first_name
		self.last_name = last_name
		self.salary = salary
	
	def give_raise(self, increment=5000):
		""" 增加年薪,默认增加5000"""
		self.salary += increment
