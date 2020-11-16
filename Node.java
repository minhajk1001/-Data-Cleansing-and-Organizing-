package datascience_test01;

public class Node {

    LikedList column;
    String data;
    Node next;
    int col_num, row_num;

    //column
    public Node(LikedList _column, String _data, Node _next, int _col_num, int _row_num) {
        column = _column;
        data = _data;
        next = _next;
        col_num = _col_num;
        row_num = _row_num;
    }

    //rows
    public Node(String _data, Node _next, int _col_num, int _row_num) {
        data = _data;
        next = _next;
        col_num = _col_num;
        row_num = _row_num;
    }
}
