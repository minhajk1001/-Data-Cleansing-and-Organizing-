package datascience_test01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataScience_Test01 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //read file
        String file_name = "file1.csv";
        FileReader file = new FileReader(file_name);
        BufferedReader br = new BufferedReader(file);

        //count total columns
        String line = br.readLine();

        int line_len = line.length();
        char line_ch_ar[] = line.toCharArray();
        int total_col = 0;
        LikedList index = new LikedList("index", 0, 0);

        String tem_str = "";
        //i = line travers, j = array travers
        for (int i = 0, j = 0; i < line_len; i++) {
            //concate
            if (line_ch_ar[i] != ',') {
                tem_str += line_ch_ar[i];
            }
            //update rows
            if (line_ch_ar[i] == ',' || i == line_ch_ar.length - 1) {
                LikedList column = new LikedList(tem_str, 0, j);
                index.add_column(column, tem_str, 0, j);
                tem_str = "";
                j++;
                total_col++;
            }
        }

        int row_num = 1, col_num = 0;
        line = br.readLine();

        while (line != null) {
            line_ch_ar = line.toCharArray();
            for (int i = 0, j = 0; i < line_ch_ar.length; i++) {
                boolean flag = false;
                //concate
                if (line_ch_ar[i] != ',') {
                    tem_str += line_ch_ar[i];
                }
                //update rows
                if (line_ch_ar[i] == ',' || i == line_ch_ar.length - 1) {
                    LikedList row = new LikedList(tem_str, 0, j);
                    Node node = index.head.next;
                    while (node != null) {
                        if (node.row_num == j) {
                            node.column.add_row(tem_str, col_num, row_num);
                            col_num++;
                            flag = true;
                            break;
                        }
                        node = node.next;
                    }
                    tem_str = "";
                    j++;
                }
            }
            col_num = 0;
            row_num++;
            line = br.readLine();
        }
//        System.out.println(total_col);
//        index.print_file();
        Node node = index.head.next;
        int row = 0;
        while (node != null) {
            System.out.print(node.data);
            for (int i = 0; i < 25 - node.data.length(); i++) {
                System.out.print(" ");
                if(i == 25 - node.data.length() - 3){
                    System.out.print("|");
                }
            }
            node = node.next;
        }
        System.out.println("");
        for (int i = 0; i < total_col * 25.5; i++) {
            System.out.print("-");
        }
        System.out.println("");
        node = index.head.next;
        while (node != null) {
            index.print_colVsRow(row, total_col);
            node = node.next;
            row++;
        }
    }
}
