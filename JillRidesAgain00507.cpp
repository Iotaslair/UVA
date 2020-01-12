#include <iostream>
#include <vector>
using namespace std;

vector<float> cache;
vector<float> endingStops;
vector<float> stops;
int bestScore(int startingPos) {
    // check cache
    float cachedValue = cache[startingPos];
    if (cachedValue == (float)((int)cachedValue)) {
        // cout << "Loaded from cache" << endl;
        return cachedValue;
    }

    // cout << "Calculating" << endl;

    int score = stops[startingPos];
    int nextScore;
    if (startingPos+1 < stops.size())
        //nextScore = bestScore(startingPos+1, stops);
        nextScore = score + bestScore(startingPos+1);
    else {
        cache[startingPos] = score;
        endingStops[startingPos] = startingPos+1;
        return score;
    }
    /*
    cout << "score " << score << endl;
    cout << "nextScore " << nextScore << endl;
    cout << "cachedValue " << cachedValue << endl;
    */

    if (score > nextScore) {
        //cout << "chose score > nextScore " << endl;
        cache[startingPos] = score;
        endingStops[startingPos] = startingPos+1;
    } else {
        //cout << "chose nextScore > score " << endl;
        //cout << "cached " << nextScore << endl;
        cache[startingPos] = nextScore;
        endingStops[startingPos] = endingStops[startingPos+1];
    }

    return cache[startingPos];
}

int main() {
    int cases, routes, niceness;
    cin >> cases;

    int currentCase = 0;
    while (currentCase++ < cases) {
        cin >> routes;

        stops.clear();
        cache.clear();
        endingStops.clear();
        while (--routes > 0) {
            cin >> niceness;
            stops.push_back(niceness);
            cache.push_back(-0.5);
            endingStops.push_back(-100);
        }

        int best = -100;
        int bestStart = -100;
        for (int i=0; i<stops.size(); i++) {
            //cout << "New number " << i << endl;
            if (best < bestScore(i)
                || (best == bestScore(i) && endingStops[i]-i > endingStops[bestStart]-bestStart)) {
                best = bestScore(i);
                bestStart = i;
            }

            //cout << "bestScore at " << i << " " << bestScore(i,stops) << endl;
        }
        //cout << "bestScore " << bestScore << endl;
        if (best > 0)
            cout << "The nicest part of route " << currentCase << " is between stops " << bestStart+1 << " and " << endingStops[bestStart]+1 << endl;
        else
            cout << "Route " << currentCase << " has no nice parts" << endl;
         //cout << "Score: " << best << endl << endl;
    }

    return 0;
}
