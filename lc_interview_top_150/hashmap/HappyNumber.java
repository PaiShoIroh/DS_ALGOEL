class Solution {
    
    private int nextNumber(int n) {
        int squareSum = 0, remainder = 0;
        while(n > 0) {
            remainder = n % 10;
            squareSum += remainder*remainder;
            n /= 10;
        }
        return squareSum;
    }

    public boolean isHappy(int n) {
        int slowPointer = n, fastPointer = nextNumber(n);
        while (slowPointer != fastPointer && fastPointer != 1) {
            slowPointer = nextNumber(slowPointer);
            fastPointer = nextNumber(nextNumber(fastPointer));
        }
        return fastPointer == 1;
    }
}

