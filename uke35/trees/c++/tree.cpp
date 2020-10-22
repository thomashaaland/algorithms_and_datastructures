#include "tree.h"


// Constructor
Tree::Tree() {
  root = NULL;
}

// Destructor
Tree::~Tree() {
  destroy_tree();
}

// Destroy tree
void Tree::destroy_tree(node *leaf) {
  if (leaf != NULL) {
    destroy_tree(leaf->left);
    destroy_tree(leaf->right);
    delete leaf;
  }
}

void Tree::insert(int key, std::string value, node *leaf) {
  if (key < leaf->key_value) {
    if (leaf->left != NULL)
      insert(key, value, leaf->left);
    else {
      leaf->left = new node;
      leaf->left->node_value = value;
      leaf->left->key_value = key;
      leaf->left->left = NULL;
      leaf->left->right = NULL;
    }
  }
  else if (key >= leaf->key_value) {
    if (leaf->right != NULL)
      insert(key, value, leaf->right);
    else {
      leaf->right = new node;
      leaf->right->key_value = key;
      lead->right->node_value = value;
      leaf->right->left = NULL;
      leaf->right->right = NULL;
    }
  }
}

Tree::node *Tree::search(int key, node *leaf) {
  if (leaf != NULL) {
    if (key == leaf->key_value)
      return leaf;
    if (key < leaf->key_value)
      return search(key, leaf->left);
    else
      return search(key, leaf->right);
  }
  else return NULL;
}

void Tree::insert(int key, std::string value) {
  if (root != NULL)
    insert(key, value, root);
  else {
    root = new node;
    root->key_value = key;
    root->node_value = value;
    root->left = NULL;
    root->right = NULL;
  }
}


Tree::node *Tree::search(int key) {
  return search(key, root);
}

std::string Tree::get_value(int key) {
  return search(key, root)->node_value;
}
  
void Tree::destroy_tree() {
  destroy_tree(root);
}
