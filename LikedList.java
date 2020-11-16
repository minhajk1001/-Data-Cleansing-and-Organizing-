package datascience_test01;

public class LikedList {

    Node head, tail;

    public LikedList(String _data, int col_num, int row_num) {
        head = new Node(_data, null, col_num, row_num);
        tail = head;
    }

    //add column
    public void add_column(LikedList list, String _data, int col_num, int row_num) {
        Node node = new Node(list, _data, null, col_num, row_num);
        tail.next = node;
        tail = node;
    }

    //add row
    public void add_row(String _data, int col_num, int row_num) {
        Node node = new Node(_data, null, col_num, row_num);
        tail.next = node;
        tail = node;
    }

    //print file
    public void print_file() {
        Node node = head.next;

        while (node != null) {
            boolean flag = true;
            Node node_nest = node.column.head;
            while (node_nest != null) {
                if (flag) {
                    System.out.println(node_nest.data + " (" + node_nest.col_num + "," + node_nest.row_num + ")");
                    System.out.println("----------------");
                    flag = false;
                } else {
                    System.out.println(node_nest.data + " (" + node_nest.col_num + "," + node_nest.row_num + ")");
                }

                node_nest = node_nest.next;
                if (node_nest == null) {
                    System.out.println("");
                }
            }
            node = node.next;
        }
        System.out.println("");
    }

    public void print_colVsRow(int row, int total_col) {
        Node node = head.next;
        int cnt = 0, prev = -1;
        while (node != null) {
            Node node_nest = node.column.head.next;
            while (node_nest != null) {
                if (node_nest.row_num == row) {
                    System.out.print(node_nest.data);
                    for (int i = 0; i < 25 - node_nest.data.length(); i++) {
                        System.out.print(" ");
                        if (i == 25 - node_nest.data.length() - 3) {
                            System.out.print("|");
                        }
                    }

                    if (total_col - 2 == cnt) {

                        System.out.println("");
                        for (int i = 0; i < total_col * 25.5; i++) {
                            System.out.print("-");
                        }
                        System.out.println("");
                    }
                    if (node_nest.row_num == prev) {
                        cnt++;
                    } else if (node_nest.row_num != prev) {
                        prev = node_nest.row_num;
                        cnt = 0;
                    }
                }

                node_nest = node_nest.next;
            }
            node = node.next;
        }
    }
}
