# 5-2 列表判断
print("5-2 列表元素判断")
cars = ['audi', 'bmw', 'toyota']
print('bmw' in cars)
print('benz' in cars)
print('Toyota' not in cars)

#5-3 if判断
print('\n5-3 if判断')
alien_color = 'red'
if 'green' == alien_color:
    print('green, get 5 points')
elif 'yellow' == alien_color:
    print('yellow, get 10 points')
elif 'red' == alien_color:
    print('red, get 15 points')

#5-8 列表配合if
print("\n 5-8 列表配合if")
users = ['li', 'an', 'admin', 'liu', 'hui']
#users = []
if users:
    for user in users:
      if 'admin' == user:
        print("Hello " + user + ", would you like to see status report?")
      else:
        print("Hello " + user + ", thank you for logging in again!")
else:
     print("We need find more users!")   

#5-10 两个列表检查
print("\n5-10 两个列表检查")
current_users = ['li', 'an', 'mu', 'liu', 'Hui']
new_users = ['li', 'hui']
for nu in new_users:
    for cu in current_users:
        if nu.lower() == cu.lower():
            print("username: " + nu  + " is already in use")
            break

#5-11 序数
print("\n 5-11 序数")
numbs = list(range(1, 11))
for num in numbs:
    if 1 == num:
        print("1st\n")
    elif 2 == num:
        print("2nd\n")
    elif 3 == num:
        print("3rd\n")
    else:
        print(str(num)+"th\n")
