package Hard;

import java.util.HashMap;
import java.util.Map;

public class _149 {
      class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int overlap = 1;
            int localMax = 0;
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int j = i+1; j <points.length ; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int g = gcd(x, y);
                if (g != 0) {
                    x /= g;
                    y /= g;
                }
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                        localMax = Math.max(map.get(x).get(y), localMax);
                    } else {
                        map.get(x).put(y, 1);
                        localMax = Math.max(1, localMax);
                    }
                } else {
                    Map<Integer, Integer> newMap = new HashMap<>();
                    newMap.put(y, 1);
                    map.put(x, newMap);
                    localMax = Math.max(1, localMax);
                }
            }
            res = Math.max(overlap + localMax, res);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
