package com.nik.impl;

import com.nik.api.LinkedList;
import java.util.Objects;

public class LinkedListImpl implements LinkedList {

  private Node firstNode;
  private Node lastNode;
  private int count;

  @Override
  public void append(int number) {
    if (firstNode == null) {
      firstNode = new Node(number);
      lastNode = firstNode;
    } else {
      Node newNode = new Node(number);
      lastNode.setNextNode(newNode);
      newNode.setPrevNode(lastNode);
      lastNode = newNode;
    }
    count++;
  }

  @Override
  public void removeTail() {
    if (lastNode == null) {
      throw new RuntimeException("You couldn't delete if list is empty");
    }
    Node prevNode = lastNode.getPrevNode();
    if (Objects.nonNull(prevNode)) {
      prevNode.setNextNode(null);
    } else {
      firstNode=null;
    }
    lastNode = prevNode;
    count--;
  }

  @Override
  public void removeGreaterThan(int number) {
    Node currentNode = firstNode;
    while (currentNode != null) {
      Node tmp = currentNode;
      if (tmp.getValue() > number) {
        removeElement(tmp);
        count--;
      }
      currentNode = tmp.getNextNode();
    }
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public int get(int index) {
    if ((index < 0) || (index > count-1)) {
      throw new IllegalArgumentException("index = "+index+" , count="+count);
    }

    Node currentNode = firstNode;
    int i = 0;
    while (i != index) {
      currentNode = currentNode.getNextNode();
      i++;
    }
    return currentNode.getValue();
  }

  private void removeElement(Node currentNode) {
    Node prevNode = currentNode.getPrevNode();
    Node nextNode = currentNode.getNextNode();
    if (Objects.nonNull(prevNode)) {
      prevNode.setNextNode(nextNode);
    }
    if (Objects.nonNull(nextNode)) {
      nextNode.setPrevNode(prevNode);
    }
    if (currentNode == firstNode) {
      firstNode = nextNode;
    }
    if (currentNode == lastNode) {
      lastNode = prevNode;
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LinkedListImpl{");
    Node currentNode = firstNode;
    while (currentNode != null) {
      stringBuilder.append(currentNode.getValue()).append(", ");
      currentNode = currentNode.getNextNode();
    }
    stringBuilder.append("}");
    return  stringBuilder.toString();
  }


}

class Node {
  private Node nextNode;
  private Node prevNode;
  private int value;

  public Node(int value) {
    this.value = value;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  public void setPrevNode(Node prevNode) {
    this.prevNode = prevNode;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public Node getPrevNode() {
    return prevNode;
  }

  public int getValue() {
    return value;
  }
}
