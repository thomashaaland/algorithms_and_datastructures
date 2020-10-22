#include<iostream>
#include "search.h"

int main() {
  int aList[] = {0, 2, 2, 3, 4, 5, 6, 9, 12, 13, 20, 21};
  int aSize = sizeof(aList)/sizeof(aList[0]);
  bool plainList = search(9, aList, aSize);
  bool sortedList = binarySearch(8, aList, aSize);
    
  std::cout << plainList << " " << sortedList << std::endl;
  return 0;
}
