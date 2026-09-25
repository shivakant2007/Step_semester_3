// WarehouseInventoryBalancer.java
public class WarehouseInventoryBalancer {

    void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Arrays must be of equal length.");
            return;
        }

        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) totalA += sectionA[i];
        for (int i = 0; i < sectionB.length; i++) totalB += sectionB[i];

        System.out.println("Section A total: " + totalA);
        System.out.println("Section B total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        int highestQty = sectionA[0];
        String section = "A";
        int index = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                section = "A";
                index = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                section = "B";
                index = i;
            }
        }

        System.out.println("Highest quantity: " + highestQty + " in Section " + section + " at index " + index);
    }

    public static void main(String[] args) {
        WarehouseInventoryBalancer balancer = new WarehouseInventoryBalancer();

        System.out.println("Test 1: Balanced arrays");
        balancer.analyzeInventory(new int[]{10, 20, 30}, new int[]{15, 25, 20});

        System.out.println();
        System.out.println("Test 2: Unbalanced arrays");
        balancer.analyzeInventory(new int[]{50, 10, 5}, new int[]{20, 20, 20});
    }
}
