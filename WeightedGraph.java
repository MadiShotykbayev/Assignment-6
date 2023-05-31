import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private ArrayList<Vertex> map = new ArrayList<Vertex>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<V> v) {
        map.add(v);
    }

    private Vertex findVertex(V data){
        for(int i = 0; i < map.size(); i++){
            if(map.get(i).getData().equals(data)) return map.get(i);
        }
        return null;
    }

    private int findVertexPosition(Vertex find){
        for(int i = 0; i < map.size(); i++){
            if(map.get(i).equals(find)) return i;
        }
        return -1;
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex _source = findVertex(source);
        Vertex _dest = findVertex(dest);
        if (!hasVertex(_source))
            addVertex(_source);

        if (!hasVertex(_dest))
            addVertex(_dest);

        if (hasEdge(_source, _dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(findVertexPosition(_source)).addAdjacentVertex(_dest, weight);

        if (undirected)
            map.get(findVertexPosition(_dest)).addAdjacentVertex(_source, weight);
    }

    public boolean hasVertex(Vertex v) {
        return map.contains(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        Boolean hasEdge = false;
        return hasEdge;
    }

    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;
        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : map.get(v)) {
            vertices.add(e.getDest());
        }
        return vertices;
    }



    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }
}

