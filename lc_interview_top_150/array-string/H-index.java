class Solution {
    public int hIndex(int[] citations) {
        int numPapers = citations.length;
        int[] buckets = new int[numPapers+1];

        for(int ci : citations) {
            if (ci >= numPapers)
                buckets[numPapers]++;
            else
                buckets[ci]++;
        }

        int hIndex = 0;
        for(int i = numPapers; i >= 0; i--) {
            hIndex += buckets[i];
            if(hIndex >= i) return i;
        }
        return 0;
    }
}
