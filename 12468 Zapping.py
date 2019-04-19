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