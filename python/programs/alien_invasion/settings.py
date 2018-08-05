class Settings():
	""" 存储 外星人入侵的所有设置类"""
	
	def __init__(self):
		""" 初始化游戏设置"""
		# 屏幕设置
		self.screen_height = 600
		self.screen_width = 1100
		self.bg_color = (230, 230, 230)
		#飞船设置
		self.ship_speed_factor = 1.5
		self.ship_limit = 3
		#子弹设置
		self.bullet_height = 15
		self.bullet_width = 3
		self.bullet_color = (60, 60, 60)
		self.bullet_speed_factor = 1
		self.bullets_allowed = 3
		#外星人设置
		self.alien_speed_factor = 1
		self.alien_fleet_drop_speed = 10
		#代表外星人的移动方向,向右为1,向左为-1
		self.alien_fleet_direction = 1
