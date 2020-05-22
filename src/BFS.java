import java.util.*;

public class BFS {
    String step = "";
    int cost = 0;
    List<String> res = new ArrayList<>();
    Queue<List<Year_Location>> queue;
    Set<Year_Location> visited;
    int time;
    Year_Location initial;
    Year_Location target;
    Map<Year_Location, List<Year_Location>> graph;
    int width;
    int height;

    public BFS(Year_Location initial, Year_Location target, Map<Year_Location, List<Year_Location>> graph, int width, int height){
        queue = new LinkedList<>();
        visited = new HashSet<>();
        time = 0;
        this.initial = initial;
        this.target = target;
        this.graph = graph;
        this.width = width;
        this.height = height;
    }
    public String getStep() {
        return step;
    }
    public int getCost() {
        return cost;
    }
    public List<String> getRes() {
        return res;
    }
    public boolean bfs() {
        visited.add(initial);
        List<Year_Location> first = new ArrayList<>();
        first.add(initial);
        queue.add(first);
        while (!queue.isEmpty()) {
            int size = queue.size();

            time++;
            for (int i = 0; i < size; i++) {
                List<Year_Location> start = queue.poll();

                if (start.get(start.size() - 1).equals(target)) {
                    step = ""+ time;
                    for (Year_Location yl : start) {
                        cost += yl.cost;
                        res.add(yl.toString());
                    }
                    return true;
                } else {
                    Year_Location cur = start.get(start.size() - 1);
                    int year = cur.year;
                    int x = cur.x;
                    int y = cur.y;
                    if (x < 0 || x >= width || y < 0 || y >= height) {
                        continue;
                    }
                    if (x + 1 < width) {
                        Year_Location temp = new Year_Location(year, x + 1, y, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d1 = new ArrayList<>(start);
                            d1.add(temp);
                            visited.add(temp);
                            queue.add(d1);
                        }
                    }
                    if (x - 1 >= 0) {
                        Year_Location temp = new Year_Location(year, x - 1, y, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d2 = new ArrayList<>(start);
                            d2.add(temp);
                            visited.add(temp);
                            queue.add(d2);
                        }
                    }
                    if (y + 1 < height) {
                        Year_Location temp = new Year_Location(year, x, y + 1, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d3 = new ArrayList<>(start);
                            d3.add(temp);
                            visited.add(temp);
                            queue.add(d3);
                        }
                    }
                    if (y - 1 < height) {
                        Year_Location temp = new Year_Location(year, x, y - 1, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d4 = new ArrayList<>(start);
                            d4.add(temp);
                            visited.add(temp);
                            queue.add(d4);
                        }
                    }
                    if (x + 1 < width && y + 1 < height) {
                        Year_Location temp = new Year_Location(year, x + 1, y + 1, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d5 = new ArrayList<>(start);
                            d5.add(temp);
                            visited.add(temp);
                            queue.add(d5);
                        }
                    }
                    if (x + 1 < width && y - 1 >= 0) {
                        Year_Location temp = new Year_Location(year, x + 1, y - 1, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d6 = new ArrayList<>(start);
                            d6.add(temp);
                            visited.add(temp);
                            queue.add(d6);
                        }
                    }
                    if (x - 1 < width && y + 1 < height) {
                        Year_Location temp = new Year_Location(year, x - 1, y + 1, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d7 = new ArrayList<>(start);
                            d7.add(temp);
                            visited.add(temp);
                            queue.add(d7);
                        }
                    }
                    if (x - 1 < width && y - 1 < height) {
                        Year_Location temp = new Year_Location(year, x - 1, y - 1, 1);
                        if (!visited.contains(temp)) {
                            List<Year_Location> d8 = new ArrayList<>(start);
                            d8.add(temp);
                            visited.add(temp);
                            queue.add(d8);
                        }
                    }

                    if (graph.containsKey(cur)) {
                        List<Year_Location> near = graph.get(cur);
                        for (Year_Location nearby : near) {
                            if (!visited.contains(nearby)) {
                                List<Year_Location> d = new ArrayList<>(start);
                                nearby.setCost(1);
                                d.add(nearby);
                                visited.add(nearby);
                                queue.add(d);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
