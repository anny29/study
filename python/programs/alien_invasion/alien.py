import pygame
from pygame.sprite import Sprite

class Alien(Sprite):
	"""外星人类"""
	def __init__(self, ai_settings, screen):
		"""初始化外星人"""
		super(Alien, self).__init__()		
		self.screen = screen
		self.settings = ai_settings
		#加载外星人图像,设置初始位置
		self.image = pygame.image.load("images/alien.bmp")
		self.rect = self.image.get_rect()
		#每个外星人都在屏幕左上角出现
		self.rect.x = self.rect.width
		self.rect.y = self.rect.height
		self.x = float(self.rect.x)
		
	def blitme(self):
		self.screen.blit(self.image, self.rect)
	
	def update(self):
		""" 更新外星人位置"""
		self.x += (self.settings.alien_speed_factor * self.settings.alien_fleet_direction)
		self.rect.x = self.x
	
	def check_edges(self):
		screen_rect = self.screen.get_rect()
		if self.rect.right >= screen_rect.right:
			return True
		if self.rect.left <= 0:
			return True
		
