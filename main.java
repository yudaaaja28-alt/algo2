public class SortAndSearch {

    // 1. Implementasi Bubble Sort dengan Optimasi Flag 'swapped'
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Optimasi: n-i-1 karena elemen terakhir sudah pasti terbesar di setiap iterasi
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Proses Tukar (Swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Jika tidak ada pertukaran, maka array sudah terurut (Optimasi)
            if (!swapped) break;
        }
    }

    // 2. Implementasi Binary Search dengan Optimasi Middle Point
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Optimasi: Menghindari overflow pada integer besar
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Data ditemukan
            } else if (arr[mid] < target) {
                low = mid + 1; // Cari di bagian kanan
            } else {
                high = mid - 1; // Cari di bagian kiri
            }
        }
        return -1; // Data tidak ditemukan
    }

    // 3. Main Method untuk Contoh Penggunaan
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        int cari = 22;

        System.out.println("Data sebelum diurutkan:");
        printArray(data);

        // Proses Pengurutan
        bubbleSort(data);

        System.out.println("\nData setelah diurutkan (Bubble Sort):");
        printArray(data);

        // Proses Pencarian
        int hasilPencarian = binarySearch(data, cari);

        if (hasilPencarian != -1) {
            System.out.println("\nAngka " + cari + " ditemukan pada indeks ke-" + hasilPencarian);
        } else {
            System.out.println("\nAngka " + cari + " tidak ditemukan.");
        }
    }

    // Helper method untuk mencetak array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}