# https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=279&page=show_problem&problem=3912
while True:
    line = input()
    if line == "-1 -1":
        break
    a, b = line.split()

    a = int(a)
    b = int(b)

    x = abs(a - b)

    y = 100 - x

    print(min(x,y))