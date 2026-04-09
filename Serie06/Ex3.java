package Serie06;

public class Ex3 {
    public static class App3<E> {

        public boolean isIn(E e, Queue<E> q) {
            int n = q.size();
            boolean found = false;

            for (int i = 0; i < n; i++) {
                E elem = q.front();
                if (e.equals(elem)) {
                    found = true;
                }

                q.dequeue();
                q.enqueue(elem);
            }
            return found;
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);

        App3<Integer> app = new App3<>();

        boolean isIn = app.isIn(8, q);
        System.out.println("IsIn: " + isIn);
    }

}
