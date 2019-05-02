public interface Stack<T> {
    /**
     *
     * @param t
     * @return the new stack after adding the element to the end of the stack
     */
    public Stack<T> push(T t);

    /**
     *
     * @return the new stack after removing the element from the end of stack
     */
    public Stack<T> pop() throws Exception;

    /**
     *
     * @return the head of stack
     */
    public T head() throws Exception;

    /**
     *
     * @return true if stack is empty, otherwise false
     */
    public boolean isEmpty();

}
