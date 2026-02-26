import java.util.*;

public class test1 {
    static class Ship {
        int code;    // ship identifier (positive for ours, negative for enemy)
        long strength; // ship strength
        
        Ship(int code, long strength) {
            this.code = code;
            this.strength = strength;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read N (number of ships) and M (number of regions)
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // Store ship information
        Map<Integer, Long> shipStrength = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int code = sc.nextInt();
            long strength = sc.nextLong();
            shipStrength.put(code, strength);
        }
        
        // Store region information
        TreeMap<Integer, List<Integer>> regions = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            int regionCode = sc.nextInt();
            int numShips = sc.nextInt();
            List<Integer> ships = new ArrayList<>();
            for (int j = 0; j < numShips; j++) {
                ships.add(sc.nextInt());
            }
            regions.put(regionCode, ships);
        }
        
        // Process each region
        for (Map.Entry<Integer, List<Integer>> entry : regions.entrySet()) {
            int regionCode = entry.getKey();
            List<Integer> ships = entry.getValue();
            
            // Simulate battle
            int result = simulateBattle(ships, shipStrength);
            System.out.println(regionCode + " " + result);
        }
        
        sc.close();
    }
    
    static int simulateBattle(List<Integer> ships, Map<Integer, Long> shipStrength) {
        Stack<Ship> stack = new Stack<>();
        
        // Process each ship in order
        for (int shipCode : ships) {
            Ship current = new Ship(shipCode, shipStrength.get(shipCode));
            
            while (!stack.isEmpty()) {
                Ship top = stack.peek();
                
                // If same side (both positive or both negative), no fight
                if ((top.code > 0 && current.code > 0) || 
                    (top.code < 0 && current.code < 0)) {
                    stack.push(current);
                    break;
                }
                
                // Fight: compare strengths
                if (top.strength > current.strength) {
                    // Top survives, current destroyed
                    break;
                } else if (top.strength < current.strength) {
                    // Current survives, top destroyed
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(current);
                        break;
                    }
                } else {
                    // Equal strength, both destroyed
                    stack.pop();
                    break;
                }
            }
            
            if (stack.isEmpty()) {
                stack.push(current);
            }
        }
        
        // Determine winner
        if (stack.isEmpty()) return 0; // Draw
        
        boolean hasOurShip = false;
        boolean hasEnemyShip = false;
        
        for (Ship ship : stack) {
            if (ship.code > 0) hasOurShip = true;
            else hasEnemyShip = true;
        }
        
        if (hasOurShip && !hasEnemyShip) return 1; // Win
        if (!hasOurShip && hasEnemyShip) return 2; // Lose
        return 0; // Draw (if both sides remain)
    }
}