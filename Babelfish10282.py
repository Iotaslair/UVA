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