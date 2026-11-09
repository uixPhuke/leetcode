import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        
        int[] requestCount = new int[k];
        int maxRequests = 0;

        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            int finishTime = currTime + load[i];

            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] freed = busyServers.poll();
                availableServers.add(freed[1]);
            }

            if (availableServers.isEmpty()) {
                continue;
            }

            int preferred = i % k;
            Integer targetServer = availableServers.ceiling(preferred);

            if (targetServer == null) {
                targetServer = availableServers.ceiling(0);
            }

            availableServers.remove(targetServer);
            busyServers.offer(new int[] { finishTime, targetServer });
            
            requestCount[targetServer]++;
            maxRequests = Math.max(maxRequests, requestCount[targetServer]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}