import pygame
import sys

from settings import Settings
from ship import Ship
from bullet import Bullet
from alien import Alien

def check_events(ai_settings, screen, ship, bullets):
	""" 监听鼠标 键盘事件"""
	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			sys.exit()		
		elif event.type == pygame.KEYDOWN:
			check_keydown_events(event, ai_settings, screen, ship, bullets)
		elif event.type == pygame.KEYUP:
			check_keyup_events(event, ship)

def check_keydown_events(event, ai_settings, screen, ship, bullets):
	""" 响应按下"""
	if event.key == pygame.K_RIGHT:
		ship.moving_right = True
	elif event.key == pygame.K_LEFT:
		ship.moving_left = True
	elif event.key == pygame.K_SPACE:
		fire_bullet(ai_settings, screen, ship, bullets)
	elif event.key == pygame.K_q:
		sys.exit()

def check_keyup_events(event, ship):
	"""响应松开"""
	if event.key == pygame.K_RIGHT:
		ship.moving_right = False
	elif event.key == pygame.K_LEFT:
		ship.moving_left = False

def update_screen(ai_settings, screen, ship, bullets, aliens):
	"""更新屏幕上的图像,并切换到新屏幕"""
	#每次循环时都重绘屏幕
	screen.fill(ai_settings.bg_color)
	for bullet in bullets.sprites():
		bullet.draw_bullet()
	
	ship.blitme()
	aliens.draw(screen)
		
	#让最近重绘的屏幕可见
	pygame.display.flip()

def update_bullets(bullets):
	bullets.update()
	#删除已消失的子弹
	for bullet in bullets.copy():
		if bullet.rect.bottom <= 0:
			bullets.remove(bullet)

def fire_bullet(ai_settings, screen, ship, bullets):
	"""没有达到子弹限制时,创建一颗子弹"""
	if len(bullets) < ai_settings.bullets_allowed:
		bullet = Bullet(ai_settings, screen, ship)
		bullets.add(bullet)

def create_fleet(ai_settings, screen, aliens):
	""" 创建一群外星人"""
	alien = Alien(ai_settings, screen)
	alien_width = alien.rect.width
	#两边留下边距
	avaliable_x = ai_settings.screen_width - 2 * alien_width
	#一个外星人占用两个宽度
	alien_number = int(avaliable_x / (2* alien_width))
	
	for i in range(alien_number):
		alien = Alien(ai_settings, screen)
		alien.x = alien_width + i * 2 * alien_width
		alien.rect.x = alien.x
		aliens.add(alien)


