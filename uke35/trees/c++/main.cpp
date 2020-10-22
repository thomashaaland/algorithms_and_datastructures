#include<iostream>
#include "tree.h"

int main()  {
  Tree tree;
  tree.insert(4, "Four");
  tree.insert(2, "Two");
  tree.insert(10, "Ten");

  int number = tree.search(10)->key_value;
  std::string value = tree.get_value(10);
  
  std::cout << number << " has value " << value << std::endl;
}
