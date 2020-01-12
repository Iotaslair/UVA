'''
Doesn't work
Problem from SENA contest (Division 1) 2016
My Professor thought it would be fun to give us some problems from
and actual competetion so that's where these problems are fun
'''
from functools import lru_cache

@lru_cache(maxsize=None)
def addBefore(word: str, index: int):
	letter = word[index]

	if letter == 'a':
		return 0

	if index == 0:
		return abs(ord(letter)-ord('a'))

	index -= 1
	next_letter = word[index]
	while next_letter >= letter:
		index -= 1

		if index < 0:
			return abs(ord(letter)-ord('a'))

		next_letter = word[index]

	other = float('inf')

	other_index = index-1
	other_letter = None
	if other_index >= 0:
		other_letter = word[other_index]
		while other_letter >= letter:
			other_index -= 1

			if other_index < 0:
				break

			other_letter = word[other_index]

	if other_letter != None and other_index >= 0:
		# print(letter,word[other_index])
		other = abs(ord(letter)-ord(other_letter)-1)+addBefore(word, other_index)

	normal = abs(ord(letter)-ord(next_letter)-1)+addBefore(word, index)

	return min(normal, other)

@lru_cache(maxsize=None)
def addAfter(word: str, index: int):
	letter = word[index]

	if letter == 'z':
		return 0

	if index == len(word)-1:
		return abs(ord('z')-ord(letter))

	index += 1
	next_letter = word[index]
	while next_letter <= letter:
		index += 1

		if index >= len(word):
			return abs(ord('z')-ord(letter))

		next_letter = word[index]

	other = float('inf')

	other_index = index+1
	other_letter = None
	if other_index < len(word)-1:
		other_letter = word[other_index]
		while other_letter <= letter:
			other_index += 1

			if other_index >= len(word):
				break

			other_letter = word[other_index]

	if other_letter != None and other_index < len(word):
		# print(letter,word[other_index])
		other = abs(ord(other_letter)-ord(letter)-1)+addAfter(word, other_index)

	normal = abs(ord(next_letter)-ord(letter)-1)+addAfter(word, index)

	return min(normal, other)

# Code

try:
	while True:
		addAfter.cache_clear()
		addBefore.cache_clear()

		line = input()
		best_score = float('inf')

		for index, char in enumerate(line):
			score = addAfter(line, index)+addBefore(line, index)
			if score < best_score:
				best_score = score

		print(best_score)
except EOFError:
	pass