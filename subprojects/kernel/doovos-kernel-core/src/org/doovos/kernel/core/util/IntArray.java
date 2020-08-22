/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author vpc
 */
public class IntArray implements Serializable {
    private transient int[] elementData;
    protected transient int modCount = 0;

    private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public IntArray(int initialCapacity) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        this.elementData = new int[initialCapacity];
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public IntArray() {
        this(10);
    }

    public IntArray(int[] arr,int offset, int length) {
        this(arr.length<3?3:length);
        System.arraycopy(arr, 0, elementData, offset, length);
    }

    public IntArray(int[] arr) {
        this(arr.length<3?3:arr.length);
        System.arraycopy(arr,0,elementData,0,arr.length);
    }


    /**
     * Trims the capacity of this <tt>ArrayList</tt> instance to be the
     * list's current size.  An application can use this operation to minimize
     * the storage of an <tt>ArrayList</tt> instance.
     */
    public void trimToSize() {
        modCount++;
        int oldCapacity = elementData.length;
        if (size < oldCapacity) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }

    /**
     * Increases the capacity of this <tt>ArrayList</tt> instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        modCount++;
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
//            int oldData[] = elementData;
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(int o) {
        for (int i = 0; i < size; i++){
            if (elementData[i] == o){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int o) {
        for (int i = size - 1; i >= 0; i--){
            if (elementData[i] == o){
                return i;
            }
        }
        return -1;
    }

    public Object clone() {
        return new IntArray(
                 elementData,0,size
         );
      }

    public int[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.  If the list fits in the
     * specified array, it is returned therein.  Otherwise, a new array is
     * allocated with the runtime type of the specified array and the size of
     * this list.
     * <p/>
     * <p>If the list fits in the specified array with room to spare
     * (i.e., the array has more elements than the list), the element in
     * the array immediately following the end of the collection is set to
     * <tt>null</tt>.  (This is useful in determining the length of the
     * list <i>only</i> if the caller knows that the list does not contain
     * any null elements.)
     *
     * @param a the array into which the elements of the list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws ArrayStoreException  if the runtime type of the specified array
     *                              is not a supertype of the runtime type of every element in
     *                              this list
     * @throws NullPointerException if the specified array is null
     */
    public void copyTo(int[] a,int offset) {
        System.arraycopy(elementData,0,a,offset,size);
    }

    public int get(int index) {
        RangeCheck(index);

        return elementData[index];
    }

    public int set(int index, int element) {
        RangeCheck(index);

        int oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     */
    public boolean add(int e) {
        ensureCapacity(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    public void add(int index, int element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);

        ensureCapacity(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    public int removeAt(int index) {
        RangeCheck(index);

        modCount++;
        int oldValue = elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        //elementData[--size] = null; // Let gc do its work

        return oldValue;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean removeElement(int o) {
        for (int index = 0; index < size; index++){
            if (o==elementData[index]) {
                fastRemove(index);
                return true;
            }
        }
        return false;
    }

    /*
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
//        elementData[--size] = null; // Let gc do its work
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        modCount++;

        size = 0;
    }

    public boolean addAll(int[] a) {
        int numNew = a.length;
        ensureCapacity(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    public boolean addAll(int index, int[] a) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);

        int numNew = a.length;
        ensureCapacity(size + numNew);  // Increments modCount

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                    numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = size - toIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex,
                numMoved);

        // Let gc do its work
//        int newSize = size - (toIndex - fromIndex);
//        while (size != newSize)
//            elementData[--size] = null;
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void RangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
    }


}
