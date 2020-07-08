public interface Graph {
    public void Init(int n);
    public int n(); // #of vertices
    public int e(); // #of edges
    public int first(int v); // First neighbor
    public int next(int v, int w); // Neighbor
    public void setEdge(int i, int j, int wght);
    public void delEdge(int i, int j);
    public boolean isEdge(int i, int j);
    public int weight(int i, int j);
    public void setMark(int v, int val);
    public int getMark(int v); // get v's Mark
}
