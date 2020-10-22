#include "search.h"

bool search(int object, int list[], int listSize) {
  for (int i = 0; i < listSize; i++) {
    if (list[i] == object) return true;
  }
  return false;
}

bool binarySearch(int object, int sortedList[], int listSize) {
  int low = 0;
  int high = listSize;
  int i;
  while (low <= high) {
    i = (high + low)/2;
    if (sortedList[i] == object) return true;
    else if (sortedList[i] < object) low = i + 1;
    else high = i - 1;
  }
  return false;
}
