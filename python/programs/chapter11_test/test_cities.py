## 测试城市输出
import unittest
from city_functions import format_city

class TestCities(unittest.TestCase):
	"""测试city_functions.py"""
	def test_format_city(self):
		""" 测试城市输出"""
		format_city_str = format_city("武汉", "中国")
		self.assertEqual(format_city_str, "武汉, 中国")
	
	def test_format_city_population(self):
		"测试含有人口时的输出"
		format_city_popu_str = format_city("newyork", "america", 2000000)
		self.assertEqual(format_city_popu_str, "Newyork, America - population 2000000")

unittest.main()

