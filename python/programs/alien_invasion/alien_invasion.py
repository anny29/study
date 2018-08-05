import pygame
from pygame.sprite import Group

from settings import Settings
from ship import Ship

import game_functions as gf

def run_game():
	#初始化游戏并创建一个屏幕对象
	pygame.init()
	ai_settings = Settings()
	screen = pygame.display.set_mode((ai_settings.screen_width, ai_settings.screen_height))
	pygame.display.set_caption("Alien Invasion")
	
	ship = Ship(screen, ai_settings)
	bullets = Group()
	aliens = Group()
	
	gf.create_fleet(ai_settings, screen, aliens, ship)
	
	while True:
		gf.check_events(ai_settings, screen, ship, bullets)
		ship.update()
		gf.update_bullets(ai_settings, screen, ship, bullets, aliens)
		gf.update_aliens(ai_settings, ship, aliens)
			
		gf.update_screen(ai_settings, screen, ship, bullets, aliens)
			
run_game()		
