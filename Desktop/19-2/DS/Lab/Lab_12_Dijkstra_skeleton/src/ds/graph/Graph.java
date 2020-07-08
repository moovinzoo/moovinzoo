package ds.graph;

public interface Graph {
    public void init(int n);
    public int n();
    public int e();
    public int first(int v);
    public int next(int v, int w);
    public void setEdge(int i, int j, double wght);
    public void delEdge(int i, int j);
    public boolean isEdge(int i, int j); // means is connected?
    public double weight(int i, int j);
    public void setMark(int v, int val);
    public int getMark(int v);
}
