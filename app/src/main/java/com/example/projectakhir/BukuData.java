package com.example.projectakhir;

import java.util.ArrayList;

public class BukuData {
    private static String[] bukuName = {
            "Manga",
            "Novel",
            "Pemrograman",
            "Antologi",
            "Biografi",
            "Dongeng",
            "Ensiklopedia",
            "History",
            "Komik"
    };

    static ArrayList<Buku> getListData() {
        ArrayList<Buku> list = new ArrayList<>();
        for (int position = 0; position < bukuName.length; position++) {
            Buku buku = new Buku();
            buku.setName(bukuName[position]);
            list.add(buku);
        }
        return list;
    }
}
