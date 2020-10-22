#ifndef TREE_H
#define TREE_H

#include <string>
#include <cstddef>

class Tree
{
 private:
  struct node {
    int key_value;
    std::string node_value;
    node *left;
    node *right;
  };
  
  void destroy_tree(node *leaf);
  void insert(int key, node *leaf);
  node *search(int key, node *leaf);

  node *root;
  
 public:
  // Constructor
  Tree();
  // Destructor
  ~Tree();
  
  //void insert(int key);
  node *search(int key);
  void insert(int key, std::string value);
  std::string get_value(int key);
  void destroy_tree();
};

#endif
