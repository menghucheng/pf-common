/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:28 PM 2019/4/1
 */
package com.mhc.tutorial;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:28 PM 2019/4/1
 *
 */
public class FirstTest {


    @Test
    public void test1(){
        List mockList = mock(List.class);

        //using mock object
        mockList.add("hello");
//        mockList.clear();

        //验证add方法是否被调用
        verify(mockList).add("hello");
        //验证add方法未被调用
//        verify(mockList,never()).add("hello");
//        验证add方法未被调用
        verify(mockList,never()).clear();
    }

    @Test
    public void test2(){
        List mockList = mock(LinkedList.class);

        when(mockList.get(0)).thenReturn("Hello");
        when(mockList.get(1)).thenReturn("mhc");

        System.out.println(mockList.get(0));
        System.out.println(mockList.get(1));

        System.out.println(mockList.get(2));

        Object o = verify(mockList).get(0);

    }

    @Test
    public void test3(){

        List mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
//        when(mockedList.contains(argThat(isValid()))).thenReturn("element");

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
//        verify(mockedList).add(argThat(someString -> someString.length() > 5));
    }

    @Test
    public void test4(){
        List mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    public void test5(){
        List mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        mockedList.clear();

    }

    @Test
    public void test6(){
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that add is first called with "was added first", then with "was added second"
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrdera = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        inOrdera.verify(firstMock).add("was called first");
        inOrdera.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will

    }

}
