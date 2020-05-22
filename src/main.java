import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String algorithm;
        int width = 0;
        int height = 0;
        int times = 0;
        boolean result = false;
        Year_Location initial = new Year_Location();
        Year_Location target = new Year_Location();
        Map<Year_Location, List<Year_Location>> graph = new HashMap<Year_Location, List<Year_Location>>();
        try {
            br = new BufferedReader(new FileReader(new File("part1\\input.txt")));
            bw = new BufferedWriter(new FileWriter(new File("part1\\output.txt")));
            String str = null;
            //See the algorithm to use
            algorithm = br.readLine();

            //Set boundary
            str = br.readLine();
            String[] boundary = str.split(" ");
            width = Integer.parseInt(boundary[0]);
            height = Integer.parseInt(boundary[1]);

            //System.out.println("width" + width + "height" + height);

            //Set initial and target location
            str = br.readLine();
            String[] start = str.split(" ");
            initial.setYear(Integer.parseInt(start[0]));
            initial.setX(Integer.parseInt(start[1]));
            initial.setY(Integer.parseInt(start[2]));


            str = br.readLine();
            String[] end = str.split(" ");
            target.setYear(Integer.parseInt(end[0]));
            target.setX(Integer.parseInt(end[1]));
            target.setY(Integer.parseInt(end[2]));


            //Set times
            str = br.readLine();
            times = Integer.parseInt(str);
            for (int i = 0; i < times; i++) {
                str = br.readLine();
                String[] channel = str.split(" ");
                Year_Location yl = new Year_Location(Integer.parseInt(channel[0]), Integer.parseInt(channel[1]), Integer.parseInt(channel[2]));
                Year_Location yl2 = new Year_Location(Integer.parseInt(channel[3]), Integer.parseInt(channel[1]), Integer.parseInt(channel[2]));
                if (graph.containsKey(yl)) {
                    List<Year_Location> near = graph.get(yl);
                    near.add(yl2);
                } else {
                    List<Year_Location> near = new ArrayList<>();
                    near.add(yl2);
                    graph.put(yl, near);
                }

                if (graph.containsKey(yl2)) {
                    List<Year_Location> near = graph.get(yl2);
                    near.add(yl);
                } else {
                    List<Year_Location> near = new ArrayList<>();
                    near.add(yl);
                    graph.put(yl2, near);
                }
            }




            //Test graph
            /*
            for (Map.Entry<Year_Location, List<Year_Location>> entry : graph.entrySet()) {
                System.out.println(entry.getKey());
                for (Year_Location y : entry.getValue()) {
                    System.out.print(y);
                }
                System.out.println();
            }
            /*


             */

            if (algorithm.equals("BFS")) {
                BFS Bfs = new BFS(initial, target, graph, width, height);
                result = Bfs.bfs();
                if (!result) {
                    bw.write("FAIL");
                } else {
                    String step = Bfs.getStep();
                    int cost = Bfs.getCost();
                    List<String> res = Bfs.getRes();
                    bw.write(cost + "\n");
                    bw.write(step + "\n");
                    for (String s : res) {
                        bw.write(s + "\n");
                    }
                }
            }

            if (algorithm.equals("UCS")) {
                UCS Ucs = new UCS(initial, target, graph, width, height);
                result = Ucs.ucs();
                if (!result) {
                    bw.write("FAIL");
                } else {
                    String step = Ucs.getStep();
                    int cost = Ucs.getCost();
                    List<String> res = Ucs.getRes();
                    bw.write(cost + "\n");
                    bw.write(step + "\n");
                    for (String s : res) {
                        bw.write(s + "\n");
                    }
                }
            }

            if (algorithm.equals("A*")) {
                A aa = new A(initial, target, graph, width, height);
                result = aa.a();
                if (!result) {
                    bw.write("FAIL");
                } else {
                    String step = aa.getStep();
                    int cost = aa.getCost();
                    List<String> res = aa.getRes();
                    bw.write(cost + "\n");
                    bw.write(step + "\n");
                    for (String s : res) {
                        bw.write(s + "\n");
                    }
                }
            }
            /*
            while((str = br.readLine()) != null)
            {
                bw.write(str + "\n");
            }



             */


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
