# https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=14&page=show_problem&problem=1223
translation = {}
line = input()
while(line != ""):
    english, foreign = line.split()
    translation[foreign] = english
    line = input()

try:
    while True:
        word = input()
        if word in translation:
            print(translation[word])
        else:
            print("eh")
except:
    pass