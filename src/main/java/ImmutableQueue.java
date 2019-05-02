public final class ImmutableQueue<T> implements Queue<T> {
    private final Stack<T> forwards;
    private final Stack<T> backwards;

    private ImmutableQueue(Stack<T> forwards, Stack<T> backwards) {
        this.forwards = forwards;
        this.backwards = backwards;
    }

    public final Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(forwards, backwards.push(t));
    }

    public final Queue<T> deQueue() throws Exception {
        Stack<T> stack = forwards.pop();
        if (!stack.isEmpty()) {
            return new ImmutableQueue<T>(stack, backwards);
        } else if (backwards.isEmpty()) {
            return ImmutableQueue.getEmptyQueue();
        } else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwards), ImmutableStack.getEmptyStack());
        }
    }

    public final T head() throws Exception {
        return forwards.head();
    }

    public final boolean isEmpty() {
        return false;
    }

    public final static Stack reverseStack(Stack stack) throws Exception {
        Stack r = ImmutableStack.getEmptyStack();
        while (!stack.isEmpty()) {
            r = r.push(stack.head());
            stack = stack.pop();
        }

        return r;
    }

    public final static Queue getEmptyQueue() {
        return EmptyQueue.getInstance();
    }

    private static final class EmptyQueue<T> implements Queue<T> {
        private final static EmptyQueue emptyQueue = new EmptyQueue();

        public final static EmptyQueue getInstance() {
            return emptyQueue;
        }

        public final Queue<T> enQueue(T t) {
            return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
        }

        public final Queue<T> deQueue() throws Exception {
            throw new Exception("Queue is Empty");
        }

        public final T head() throws Exception {
            throw new Exception("Queue is Empty");
        }

        public final boolean isEmpty() {
            return true;
        }
    }
}
