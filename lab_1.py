import random as r
m = int(input("Введіть число m: "))
n = 0
for i in range(m):
    if str(r.randint(10000, 99999)).count('5') >= 3:
        n += 1

print("P(a)= {0}".format(n/m))
