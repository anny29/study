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

def update_bullets(ai_settings, screen, ship, bullets, aliens):
	bullets.update()
	#删除已消失的子弹
	for bullet in bullets.copy():
		if bullet.rect.bottom <= 0:
			bullets.remove(bullet)
	check_bullet_alien_collisions(ai_settings, screen, ship, bullets, aliens)
	
	
def check_bullet_alien_collisions(ai_settings, screen, ship, bullets, aliens):
	""" 检查子弹和外星人的碰撞"""
	collisions = pygame.sprite.groupcollide(bullets, aliens, True, True)
	
	if len(aliens) == 0:
		bullets.empty()
		create_fleet(ai_settings, screen, aliens, ship)

def fire_bullet(ai_settings, screen, ship, bullets):
	"""没有达到子弹限制时,创建一颗子弹"""
	if len(bullets) < ai_settings.bullets_allowed:
		bullet = Bullet(ai_settings, screen, ship)
		bullets.add(bullet)

def create_fleet(ai_settings, screen, aliens, ship):
	""" 创建一群外星人"""
	alien = Alien(ai_settings, screen)
	#计算一行能放置几个外星人
	number_aliens_x = get_number_aliens_x(ai_settings, alien.rect.width)
	#计算能放置几行外星人
	number_aliens_y = get_number_aliens_y(ai_settings, alien.rect.height, ship.rect.height)
	
	for col_number in range(number_aliens_x):
		for row_number in range(number_aliens_y):
			create_alien(ai_settings, screen, aliens, col_number, row_number)

def get_number_aliens_x(ai_settings, alien_width):
	""" 一行能创建的外星人个数"""
	#两边留下边距
	avaliable_x = ai_settings.screen_width - 2 * alien_width
	#一个外星人占用两个宽度
	return int(avaliable_x / (2* alien_width))

def create_alien(ai_settings, screen, aliens, col_number, row_number):
	""" 创建一个外星人,并设置位置"""
	alien = Alien(ai_settings, screen)
	alien.x = alien.rect.width +  col_number * 2 * alien.rect.width
	alien.rect.x = alien.x
	alien.rect.y = alien.rect.height + row_number * 2 * alien.rect.height
	aliens.add(alien)

def get_number_aliens_y(ai_settings, alien_height, ship_height):
	""" 获取能创建几行外星人"""
	#屏幕高度减去外星人与顶部的间距(一个外星人高度),在减去外星人与飞船的间距,再减去飞船的高度
	avaliable_y = ai_settings.screen_height - 3 * alien_height - ship_height
	return int(avaliable_y / (2* alien_height))

def update_aliens(ai_settings, ship, aliens):
	""" 更新外星人"""
	for alien in aliens.sprites():
		if alien.check_edges():
			change_fleet_direction(ai_settings, aliens)
			break
	aliens.update()
	
	if pygame.sprite.spritecollideany(ship, aliens):
		print("Ship hit!!")

def change_fleet_direction(ai_settings, aliens):
	""" 更新外星人移动方向"""
	for alien in aliens.sprites():
		alien.rect.y += ai_settings.alien_fleet_drop_speed
	ai_settings.alien_fleet_direction *= -1


