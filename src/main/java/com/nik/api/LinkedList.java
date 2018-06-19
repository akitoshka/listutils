package com.nik.api;

/*
  int type linkedlist
 */
public interface LinkedList {

  /**
   * Append an element into the linkedlist
   * @param number - element will be added to tail
   */
  void append(int number);

  /**
   *  Remove the tail element from a linkedlist
   */
  void removeTail();

  /**
   * Remove all element in the linkedlist that is great than a target value
   * @param number - target value
   */
  void removeGreaterThan(int number);

  /**
   * Count of elements
   * @return count
   */
  int size();

  /**
   * Get element by index
   * @param index - index of element
   * @return value
   */
  int get(int index);
}
