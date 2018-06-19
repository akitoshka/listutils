package com.nik;

import static org.junit.Assert.assertTrue;

import com.nik.api.LinkedList;
import com.nik.impl.LinkedListImpl;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class LinkedListTest {

  @Test(expected = IllegalArgumentException.class)
  public void testGetNegative() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.get(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetOutOgRange() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.get(56);
  }

  @Test
  public void testAppendOnlyOneElement() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    assertTrue(list.get(0) == 0);
    assertTrue(list.size() == 1);
  }

  @Test
  public void testAppendFewElement() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.append(2);
    list.append(3);
    assertTrue(list.get(0) == 0);
    assertTrue(list.get(1) == 2);
    assertTrue(list.get(2) == 3);
    assertTrue(list.size() == 3);
  }

  @Test
  public void testAppendAndRemoveTail() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.append(2);
    list.append(3);
    list.removeTail();
    assertTrue(list.get(0) == 0);
    assertTrue(list.get(1) == 2);
    assertTrue(list.size() == 2);
  }

  @Test
  public void testAppendAndRemoveTailForAllElements() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.append(2);
    list.append(3);
    list.removeTail();
    list.removeTail();
    list.removeTail();
    assertTrue(list.size() == 0);
  }

  @Test(expected = RuntimeException.class)
  public void testRemoveTailOnEmptyList() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.append(2);
    list.append(3);
    list.removeTail();
    list.removeTail();
    list.removeTail();
    list.removeTail();
  }

  @Test
  public void testDeleteGraterThan() {
    LinkedList list = new LinkedListImpl();
    list.append(0);
    list.append(2);
    list.append(3);
    list.removeGreaterThan(2);
    assertTrue(list.get(0) == 0);
    assertTrue(list.get(1) == 2);
    assertTrue(list.size() == 2);
  }
}
