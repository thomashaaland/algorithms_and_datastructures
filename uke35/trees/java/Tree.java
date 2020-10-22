interface Tree<T> {
    public void insert(T key);
    public void delete(T key);
    public boolean exists(T key);
    //public int depth(T key);
    public int longestPath();
    public int shortestPath();
    public T findSmallestElement();
    public T findLargestElement();
}
