package FinalExam;

import java.util.ArrayList;
import java.util.List;

public class Q1_2018 {
    class Node {
        int value;
        int rank;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Node sort(Node list) {
        Node node = list;
        List<Node> l = new ArrayList<>();
        while (node != null) {
            l.add(node);
            node = node.next;
        }
        for (int i = 0; i < l.size() - 1; i++)
            for (int j = i + 1; j < l.size(); j++)
                if (l.get(i).value > l.get(j).value) {
                    node = l.get(i);
                    l.set(i, l.get(j));
                    l.set(j, node);
                }
        int r = 1;
        l.get(0).rank = 1;
        for (int i = 1; i < l.size(); i++)
            if (l.get(i).value > l.get(i - 1).value)
                l.get(i).rank = ++r;
            else
                l.get(i).rank = r;
        list = l.get(0);
        node = list;
        for (int i = 1; i < l.size(); i++) {
            node.next = l.get(i);
            node = node.next;
        }
        node.next = null;
        return list;
    }

    public static void main(String[] args) {
        Q1_2018 q = new Q1_2018();
        Node list = q.new Node(7);
        list.next = q.new Node(5);
        list.next.next = q.new Node(2);
        list.next.next.next = q.new Node(4);
        Node node = q.sort(list);
        while (node != null) {
            System.out.println("(" + node.value + "," + node.rank + ") ");
            node = node.next;
        }
    }
}
