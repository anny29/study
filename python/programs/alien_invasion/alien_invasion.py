import pygame
from pygame.sprite import Group

from settings import Settings
from ship import Ship
from game_status import GameStatus
from button import Button

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
	status = GameStatus(ai_settings)
	play_button = Button(ai_settings, screen, "Play")
	
	gf.create_fleet(ai_settings, screen, aliens, ship)
	
	while True:
		gf.check_events(ai_settings, screen, ship, aliens, bullets, play_button, status)
		if status.game_active:
			ship.update()
			gf.update_bullets(ai_settings, screen, ship, bullets, aliens)
			gf.update_aliens(ai_settings, screen, ship, aliens, bullets, status)
			
		gf.update_screen(ai_settings, screen, ship, bullets, aliens, status, play_button)
			
run_game()		
