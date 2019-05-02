public class PayPay {
    public static void main(String[] args) {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue();
        try {
            queue = queue.enQueue(1);
            print(queue);
            queue = queue.enQueue(2);
            print(queue);
            queue = queue.deQueue();
            print(queue);
            queue = queue.deQueue();
            print(queue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void print(Queue<Integer> q) throws Exception{
        while(q != null && !q.isEmpty()){
            System.out.print(q.head() + " -> ");
            q = q.deQueue();
        }
        System.out.println();
    }
}
