import sys

import pygame
from settings import Settings
from ship import Ship

def run_game():
	#初始化游戏并创建一个屏幕对象
	pygame.init()
	ai_settings = Settings()
	screen = pygame.display.set_mode((ai_settings.screen_width, ai_settings.screen_height))
	pygame.display.set_caption("Alien Invasion")
	
	ship = Ship(screen)
	
	while True:
		
		#监听鼠标 键盘事件
		for event in pygame.event.get():
			if event.type == pygame.QUIT:
				sys.exit()
		
		#每次循环时都重绘屏幕
		screen.fill(ai_settings.bg_color)
		ship.blitme()
		
		#让最近重绘的屏幕可见
		pygame.display.flip()

run_game()		
