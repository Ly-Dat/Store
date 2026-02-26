
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGENSHIN2 {

    static ArrayList<ArrayList<String>> skills = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Pyro", "Hydro")),
            new ArrayList<>(Arrays.asList("Pyro", "Cryo")),
            new ArrayList<>(Arrays.asList("Pyro", "Electro")),
            new ArrayList<>(Arrays.asList("Hydro", "Cryo")),
            new ArrayList<>(Arrays.asList("Hydro", "Electro")),
            new ArrayList<>(Arrays.asList("Cryo", "Electro"))
    ));
    static double[] buff = {1, 0.5, 0.3, 0.2, 0.3, 0.3};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        HashMap<String, character> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String name = sc.next();
            character ch = new character(name);
            ch.setDame(sc.nextInt(), sc.nextInt(), sc.next());
            map.put(name, ch);
        }
        String lastName = null;
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int hit = sc.nextInt();
            if (map.containsKey(name)) {
                if (map.containsKey(lastName)) {
                    map.get(name).attack(hit, map.get(lastName));
                } else {
                    map.get(name).attack(hit, map.get(name));
                }
            }
            lastName = name;
        }
        ArrayList<character> list = new ArrayList<>(map.values());
        list.sort((p1, p2) -> {
            int a = Double.compare(p2.sum, p1.sum);
            if (a != 0) {
                return a;
            }
            return p1.name.compareTo(p2.name);
        });

        if (list.size() <= K) {
            list.forEach(p -> sb.append(p).append("\n"));
        } else {
            double endCharacter = list.get(K).sum;
            list.forEach(p -> {
                if (Double.compare(p.sum, endCharacter) != 0) {
                    sb.append(p).append("\n");
                }
            });
        }

        System.out.println(sb);
    }

    static class character {

        boolean critical = false;
        String name;
        String skill;
        int[] dame = new int[2];
        double sum = 0;

        public character(String name) {
            this.name = name;

        }

        public void setDame(int normal, int critical, String skill) {
            dame[0] = normal;
            dame[1] = critical;
            this.skill = skill;
        }

        public void attack(int n, character other) {
            if(n==1){
                critical=true;
            }
            double buffDame = 0;
            for (var t : skills) {
                if (!skill.equals(other.skill) && other.critical && t.contains(skill) && t.contains(other.skill)) {
                    buffDame = buff[skills.indexOf(t)];
                    break;
                }
            }
            sum += dame[n] * (1 + buffDame);

        }

        @Override
        public String toString() {
            return name + " " + Math.round(sum);
        }

    }
}
