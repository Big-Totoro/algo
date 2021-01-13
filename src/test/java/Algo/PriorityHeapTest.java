package Algo;

import Algo.Misc.PriorityHeap;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityHeapTest {

    @Test
    public void test11() {
        PriorityHeap<Integer> priorityHeap = new PriorityHeap<>(Integer.class);
        assertThat(priorityHeap.size()).isEqualTo(0);
    }

    @Test
    public void test12() {
        PriorityHeap<Integer> priorityHeap = new PriorityHeap<>(Integer.class);
        priorityHeap.offer(1);
        assertThat(priorityHeap.size()).isEqualTo(1);
    }

    @Test
    public void test13() {
        PriorityHeap<Integer> priorityHeap = new PriorityHeap<>(Integer.class);
        priorityHeap.offer(1);
        Integer value = priorityHeap.peek();
        assertThat(value).isEqualTo(1);
    }

    @Test
    public void test14() {
        PriorityHeap<Integer> priorityHeap = new PriorityHeap<>(Integer.class);
        priorityHeap.offer(2);
        priorityHeap.offer(3);
        priorityHeap.offer(4);
        priorityHeap.offer(1);

        assertThat(priorityHeap.size()).isEqualTo(4);

        Integer value = priorityHeap.peek();
        assertThat(value).isEqualTo(1);
    }

    @Test
    public void test15() {
        PriorityHeap<Integer> priorityHeap = new PriorityHeap<>(Integer.class);
        priorityHeap.offer(1);
        priorityHeap.offer(2);
        priorityHeap.offer(3);
        priorityHeap.offer(4);

        assertThat(priorityHeap.size()).isEqualTo(4);

        Integer value = priorityHeap.pop();
        assertThat(value).isEqualTo(1);
        assertThat(priorityHeap.size()).isEqualTo(3);

        value = priorityHeap.pop();
        assertThat(value).isEqualTo(2);
        assertThat(priorityHeap.size()).isEqualTo(2);

        value = priorityHeap.pop();
        assertThat(value).isEqualTo(1);
        assertThat(priorityHeap.size()).isEqualTo(0);
    }
}
