import java.util.*;
import java.io.*;

public class EIUGENSHIN2 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        double[][] elemReactTable = {
                { .0, 1.0, .5, .3 },
                { 1.0, .0, .2, .3 },
                { .5, .2, .0, .3 },
                { .3, .3, .3, .0 }
        };

        int nAttacks = sc.nextInt();
        int nChars = sc.nextInt();
        int kTopDamage = sc.nextInt();

        Map<String, CharGI> mapChars = new HashMap<>();
        while (nChars-- > 0) {
            CharGI chr = new CharGI(sc.next(), sc.nextLong(), sc.nextLong(), encodeElement(sc.next()));
            mapChars.put(chr.name, chr);
        }

        int prevElement = -1;
        while (nAttacks-- > 0) {
            CharGI chr = mapChars.get(sc.next());
            int enable = sc.nextInt();
            if (prevElement == -1) {
                chr.totalDamage += (enable == 0) ? chr.attackDamage : chr.criticalDamage;
                prevElement = chr.number_encodedElement;
            } else if (prevElement != chr.number_encodedElement) {
                chr.totalDamage += ((enable == 0) ? chr.attackDamage : chr.criticalDamage)
                        * (1.0 + elemReactTable[prevElement][chr.number_encodedElement]);
                prevElement = -1;
            } else {
                chr.totalDamage += (enable == 0) ? chr.attackDamage : chr.criticalDamage;
            }
        }
        List<CharGI> listChars = new ArrayList<>(mapChars.values());
        listChars.sort((a, b) -> {
            int cmp = Double.compare(b.totalDamage, a.totalDamage);
            return cmp != 0 ? cmp : a.name.compareTo(b.name);
        });

        double pivotDamage = (listChars.size() > kTopDamage) ? listChars.get(kTopDamage - 1).totalDamage : 0;
        for (CharGI charGI : listChars) {
            if (charGI.totalDamage < pivotDamage)
                break;
            sb.append(charGI.name).append(" ").append(charGI.totalDamage).append("\n");
        }
        System.out.println(sb);
    }

    private static int encodeElement(String element) {
        switch (element) {
            case "Pyro":
                return 0;
            case "Hydro":
                return 1;
            case "Cryo":
                return 2;
            default:
                return 3;
        }
    }

    static class CharGI {
        String name;
        long attackDamage;
        long criticalDamage;
        int number_encodedElement;
        double totalDamage;
        double transferDamagaIntoDouble;

        public CharGI(String name, long attackDamage, long criticalDamage, int number_encodedElement) {
            this.name = name;
            this.attackDamage = attackDamage;
            this.criticalDamage = criticalDamage;
            this.number_encodedElement = number_encodedElement;
        }

    }
}
