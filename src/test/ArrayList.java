package test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrayList<E> extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
private static final long serialVersionUID = 8683452581122892189L;

/**
* Default initial capacity.
*/
private static final int DEFAULT_CAPACITY = 10;

/**
* Shared empty array instance used for empty instances.
*/
public static final Object[] EMPTY_ELEMENTDATA = {};

/**
* Shared empty array instance used for default sized empty instances. We
* distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
* first element is added.
*/
public static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

/**
* The array buffer into which the elements of the ArrayList are stored.
* The capacity of the ArrayList is the length of this array buffer. Any
* empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
* will be expanded to DEFAULT_CAPACITY when the first element is added.
*/
transient static Object[] elementData; // non-private to simplify nested class access

/**
* The size of the ArrayList (the number of elements it contains).
*
* @serial
*/
private int size;

/*
public ArrayList(int initialCapacity) {
if (initialCapacity > 0) {
    this.elementData = new Object[initialCapacity];
} else if (initialCapacity == 0) {
    this.elementData = EMPTY_ELEMENTDATA;
} else {
    throw new IllegalArgumentException("Illegal Capacity: "+
                                       initialCapacity);
}
}*/

/**
* Constructs an empty list with an initial capacity of ten.
*/

public ArrayList() {
	
this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
/*
public ArrayList(Collection<? extends E> c) {
elementData = c.toArray();
if ((size = elementData.length) != 0) {
    // c.toArray might (incorrectly) not return Object[] (see 6260652)
    if (elementData.getClass() != Object[].class)
        elementData = Arrays.copyOf(elementData, size, Object[].class);
} else {
    // replace with empty array.
    this.elementData = EMPTY_ELEMENTDATA;
}
}

public void trimToSize() {
modCount++;
if (size < elementData.length) {
    elementData = (size == 0)
      ? EMPTY_ELEMENTDATA
      : Arrays.copyOf(elementData, size);
}
}
*/
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}

public static int ensureCapacity(int minCapacity) {
int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
    // any size if not default element table
    ? 0
    // larger than default for default empty table. It's already
    // supposed to be at default size.
    : DEFAULT_CAPACITY;

if (minCapacity > minExpand) {
    ensureExplicitCapacity(minCapacity);
}
  return minExpand;
}

public void ensureCapacityInternal(int minCapacity) {
if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
    minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
}

ensureExplicitCapacity(minCapacity);
}

public static void ensureExplicitCapacity(int minCapacity) {


// overflow-conscious code
if (minCapacity - elementData.length > 0)
    grow(minCapacity);
}


public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 10;

public static int grow(int minCapacity) {
// overflow-conscious code
int oldCapacity = elementData.length;
int newCapacity = oldCapacity + (oldCapacity >> 1);
if (newCapacity - minCapacity < 0)
    newCapacity = minCapacity;
if (newCapacity - MAX_ARRAY_SIZE > 0)
    newCapacity = MAX_ARRAY_SIZE;
// minCapacity is usually close to size, so this is a win:
elementData = Arrays.copyOf(elementData, newCapacity);
return newCapacity;
}

public static int hugeCapacity(int minCapacity) {
if (minCapacity < 0) // overflow
    throw new OutOfMemoryError();
return (minCapacity > MAX_ARRAY_SIZE) ?
    //Integer.MAX_VALUE :
		minCapacity :
    MAX_ARRAY_SIZE-10;
}

public int size() {
return size;
}
public boolean isEmpty() {
return size == 0;
}

public E get(int index) {
// TODO Auto-generated method stub
return null;
}
}
