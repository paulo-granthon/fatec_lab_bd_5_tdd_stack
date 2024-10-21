package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberAscOrderTest {
  private CustomStack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new CustomStack<>(6, element -> element);
  }

  @Test
  void testSortWithSixNumbers() throws StackFullException, StackEmptyException {
    stack.push(23);
    stack.push(42);
    stack.push(15);
    stack.push(8);
    stack.push(34);
    stack.push(19);

    NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
    List<Integer> sortedNumbers = sorter.sort();

    assertEquals(List.of(8, 15, 19, 23, 34, 42), sortedNumbers);
  }

  @Test
  void testSortWithEmptyStack() {
    NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);

    assertThrows(StackEmptyException.class, sorter::sort);
  }
}
