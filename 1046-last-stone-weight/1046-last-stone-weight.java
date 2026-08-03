class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b-a
        );

        for(int n : stones){
            pq.add(n);
        }

        while(pq.size() > 1){
            int f = pq.poll();
            int s = pq.poll();

            if(f != s){
                pq.add(f-s);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}