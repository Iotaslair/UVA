tests = int(input())
for repeat in range(tests):
    days = int(input())
    parties = int(input())
    hartals = []
    days_off = 0
    for again in range(parties):
        hartals.append(int(input()))
    for day in range(1, days+1):
        if (day%7 == 0 or day%7 == 6):
            continue
        for hartal in hartals:
            if day%hartal == 0:
                days_off += 1
                break
    print(days_off)