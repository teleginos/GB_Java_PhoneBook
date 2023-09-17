import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    public static void main(String[] args) {
        List<Entry> entries = List.of(
                new Entry("Анна", "12345"),
                new Entry("Анна", "67890"),
                new Entry("Борис", "11111"),
                new Entry("Анна", "54321"),
                new Entry("Дмитрий", "99999"),
                new Entry("Борис", "22222"),
                new Entry("Виктор", "33333")
        );

        System.out.println(getSortedPhoneBook(entries));
    }

    public static List<Map.Entry<String, Set<String>>> getSortedPhoneBook(List<Entry> entries) {
        Map<String, Set<String>> phoneBookMap = new HashMap<>();

        for (Entry entry : entries) {
            phoneBookMap.computeIfAbsent(entry.name, k -> new HashSet<>()).add(entry.phone);
        }

        List<Map.Entry<String, Set<String>>> phoneBookList = new ArrayList<>(phoneBookMap.entrySet());
        phoneBookList.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        return phoneBookList;
    }

    static class Entry {
        String name;
        String phone;

        Entry(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
