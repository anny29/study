
class GameStatus():
	""" 跟踪游戏的统计信息"""
	
	def __init__(self, ai_settings):
		""" 初始化统计信息"""
		self.ai_settings = ai_settings
		self.reset_status()
		self.game_active = False
	
	def reset_status(self):
		""" 初始化在游行运行期间可变化的统计信息"""
		self.ship_left = self.ai_settings.ship_limit
		
		
