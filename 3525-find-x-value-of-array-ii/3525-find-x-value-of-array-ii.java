class Solution {

    static class Node {
        int product;
        int[] count;

        Node(int k) {
            product = 1 % k;
            count = new int[k];
        }
    }

    int k;
    Node[] tree;

    private Node merge(Node left, Node right) {
        Node res = new Node(k);

        // Product of the complete segment
        res.product = (left.product * right.product) % k;

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            res.count[r] = left.count[r];
        }

        // Prefixes that extend into right
        for (int r = 0; r < k; r++) {
            if (right.count[r] == 0) continue;

            int newRemainder = (left.product * r) % k;
            res.count[newRemainder] += right.count[r];
        }

        return res;
    }

    private void build(int[] nums, int node, int l, int r) {

        if (l == r) {
            int remainder = nums[l] % k;

            tree[node].product = remainder;
            tree[node].count[remainder] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private void update(
        int node,
        int l,
        int r,
        int index,
        int value
    ) {

        if (l == r) {

            int remainder = value % k;

            tree[node] = new Node(k);
            tree[node].product = remainder;
            tree[node].count[remainder] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private Node query(
        int node,
        int l,
        int r,
        int ql,
        int qr
    ) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return query(
                node * 2,
                l,
                mid,
                ql,
                qr
            );
        }

        if (ql > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                r,
                ql,
                qr
            );
        }

        Node left = query(
            node * 2,
            l,
            mid,
            ql,
            qr
        );

        Node right = query(
            node * 2 + 1,
            mid + 1,
            r,
            ql,
            qr
        );

        return merge(left, right);
    }

    public int[] resultArray(
        int[] nums,
        int k,
        int[][] queries
    ) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node(k);
        }

        build(nums, 1, 0, n - 1);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(
                1,
                0,
                n - 1,
                index,
                value
            );

            // Query [start, n - 1]
            Node result = query(
                1,
                0,
                n - 1,
                start,
                n - 1
            );

            answer[i] = result.count[x];
        }

        return answer;
    }
}