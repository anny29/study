## 雇员测试类 
import unittest
from employee import Employee

class TestEmployee(unittest.TestCase):
	""" 针对Employee的测试类"""
	def setUp(self):
		""" 实例化一个雇员"""
		self.emp = Employee("Tim", "Dukan", 2000)
	
	def test_give_default_raise(self):
		""" 测试默认年薪增长"""
		self.emp.give_raise()
		self.assertEqual(7000, self.emp.salary)
		
	def test_give_custom_raise(self):
		"""测试指定年薪增长"""
		self.emp.give_raise(2000)
		self.assertEqual(4000, self.emp.salary)

unittest.main()
	
