class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{servers[i], i, 0});
        }

        int[] ans = new int[tasks.length];
        int currentTime = 0;

        for (int j = 0; j < tasks.length; j++) {
            currentTime = Math.max(currentTime, j);

            if (freeServers.isEmpty() && busyServers.peek()[0] > currentTime) {
                currentTime = busyServers.peek()[0];
            }

            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                int[] server = busyServers.poll();
                freeServers.offer(new int[]{server[1], server[2], server[0]});
            }

            int[] server = freeServers.poll();
            ans[j] = server[1];
            busyServers.offer(new int[]{currentTime + tasks[j], server[0], server[1]});
        }

        return ans;
    }
}