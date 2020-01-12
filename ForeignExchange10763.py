# https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=19&page=show_problem&problem=1704
def incr(dict, key):
    if key in dict:
        dict[key] += 1
    else:
        dict[key] = 1
        
line = input()
answers = []
while (line != "0"):
    cases = int(line)
    normal = {}
    reverse = {}
    for repeat in range(cases):
        a, b = input().split()
        a = int(a)
        b = int(b)
        
        incr(normal, (a,b))
        incr(reverse, (b,a))
        
    if (normal == reverse):
        answers.append("YES")
    else:
        answers.append("NO")
    line = input()

for answer in answers:
    print(answer)

